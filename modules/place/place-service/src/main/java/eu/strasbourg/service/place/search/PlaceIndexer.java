package eu.strasbourg.service.place.search;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelperUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.service.place.model.SubPlace;
import eu.strasbourg.service.place.service.PlaceLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.IndexHelper;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Component(immediate = true, service = Indexer.class)
public class PlaceIndexer extends BaseIndexer<Place> {

	public static final String CLASS_NAME = Place.class.getName();

	public PlaceIndexer() {
        setDefaultSelectedFieldNames(
                Field.ASSET_TAG_NAMES, Field.COMPANY_ID, Field.CONTENT,
                Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK, Field.GROUP_ID,
                Field.MODIFIED_DATE, Field.SCOPE_GROUP_ID, Field.TITLE, Field.UID);

        setFilterSearch(true);
		setPermissionAware(true);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	protected void doDelete(Place place) throws Exception {
		deleteDocument(place.getCompanyId(), place.getPlaceId());
	}

	/**
	 * Fonction appelée lors de l'indexation de l'item C'est ici qu'on choisi
	 * les champs à indexer
	 */
	@Override
	protected Document doGetDocument(Place place) throws Exception {
		Document document = getBaseModelDocument(CLASS_NAME, place);

		// On indexe toute la hiérarchie de catégories (parents et enfants des
		// catégories de l'entité)
		long[] assetCategoryIds = AssetVocabularyHelper
				.getFullHierarchyCategoriesIds(place.getCategories());
		List<AssetCategory> assetCategories = AssetVocabularyHelper
				.getFullHierarchyCategories(place.getCategories());
		document.addKeyword(Field.ASSET_CATEGORY_IDS, assetCategoryIds);
		IndexHelper.addAssetCategoryTitles(document, Field.ASSET_CATEGORY_TITLES,
				assetCategories);


		document.addText(Field.TITLE, place.getAlias(Locale.FRANCE));
		Map<Locale, String> typeMap = new HashMap<Locale, String>();
		Map<Locale, String> cityMap = new HashMap<Locale, String>();

		for (Map.Entry<Locale, String> titleMap : place.getAliasMap().entrySet()) {
			Locale locale = titleMap.getKey();
			String type = place.getTypeLabel(locale);
			typeMap.put(locale, type);
		}


		AssetCategory cityCategory = place.getCityCategory();
		if (cityCategory != null) {
			for (Map.Entry<Locale, String> titleMap : cityCategory.getTitleMap().entrySet()) {
				Locale locale = titleMap.getKey();
				String type = place.getCity(locale);
				cityMap.put(locale, type);
			}
		}

		document.addLocalizedText("typeLabel", typeMap);
		document.addLocalizedText("location", cityMap);

		document.addLocalizedText(Field.TITLE, place.getAliasMap());

		Map<Locale, String> descriptionMap = new HashMap<Locale, String>();
		Map<Locale, String> contentMap = new HashMap<Locale, String>();
		
		for (Map.Entry<Locale, String> titleMap : place.getAliasMap().entrySet()) {
			Locale locale = titleMap.getKey();

			// On ajoute les données de service et activité, tarif, nom et description des
			// sous-lieux d'un lieu dans la map présentation
			String description = place.getSIGid();
			description += place.getPresentation(locale);
			description += place.getServiceAndActivities(locale);
			if (place.getPrice() != null) {
				description += place.getPrice().getPriceDescription(locale);
			}
			for (SubPlace subPlace : place.getSubPlaces()) {
				description += subPlace.getName(locale);
				description += subPlace.getDescription(locale);
			}
			descriptionMap.put(locale, description);
			

			// On ajoute les données de accès et services aux personnes handicapées,
			// informations complémentaires des
			// sous-lieux d'un lieu dans la map caractéristique
			String content = place.getCharacteristics(locale);
			content += place.getAccessForDisabled(locale);
			content += place.getAdditionalInformation(locale);
			contentMap.put(locale, content);
		}
		document.addLocalizedText(Field.DESCRIPTION, descriptionMap);
		document.addLocalizedText(Field.CONTENT, contentMap); 
		
		document.addNumber(Field.STATUS, place.getStatus());
		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale,
			String snippet, PortletRequest portletRequest,
			PortletResponse portletResponse) throws Exception {
		Summary summary = createSummary(document, Field.TITLE, Field.URL);
		return summary;
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		Place entry = PlaceLocalServiceUtil.getPlace(classPK);
		doReindex(entry);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexEntries(companyId);
	}

	@Override
	protected void doReindex(Place place) throws Exception {
		Document document = getDocument(place);

		IndexWriterHelperUtil.updateDocument(place.getCompanyId(), document);

	}

	protected void reindexEntries(long companyId) throws PortalException {
		final IndexableActionableDynamicQuery indexableActionableDynamicQuery = PlaceLocalServiceUtil
				.getIndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setAddCriteriaMethod(
				new ActionableDynamicQuery.AddCriteriaMethod() {
					@Override
					public void addCriteria(DynamicQuery dynamicQuery) {

					}
				});
		indexableActionableDynamicQuery.setCompanyId(companyId);
		indexableActionableDynamicQuery.setPerformActionMethod(
				new ActionableDynamicQuery.PerformActionMethod<Place>() {

					@Override
					public void performAction(Place entry) {
						try {
							Document document = getDocument(entry);

							indexableActionableDynamicQuery
									.addDocuments(document);
						} catch (PortalException pe) {
							_log.error("Unable to index place entry "
									+ entry.getPlaceId());
						}
					}

				});

		indexableActionableDynamicQuery.performActions();
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}
