package eu.strasbourg.portlet.dynamic_search_asset;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleServiceUtil;
import com.liferay.portal.configuration.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.SessionParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.spring.extender.service.ServiceReference;
import com.liferay.portlet.documentlibrary.lar.FileEntryUtil;
import eu.strasbourg.portlet.dynamic_search_asset.configuration.DynamicSearchAssetConfiguration;
import eu.strasbourg.portlet.dynamic_search_asset.constants.Constants;
import eu.strasbourg.service.activity.model.Activity;
import eu.strasbourg.service.activity.model.ActivityCourse;
import eu.strasbourg.service.activity.service.ActivityCourseLocalServiceUtil;
import eu.strasbourg.service.activity.service.ActivityLocalServiceUtil;
import eu.strasbourg.service.agenda.model.Event;
import eu.strasbourg.service.agenda.model.Manifestation;
import eu.strasbourg.service.agenda.service.EventLocalServiceUtil;
import eu.strasbourg.service.agenda.service.ManifestationLocalServiceUtil;
import eu.strasbourg.service.edition.model.Edition;
import eu.strasbourg.service.edition.model.EditionGallery;
import eu.strasbourg.service.edition.service.EditionGalleryLocalServiceUtil;
import eu.strasbourg.service.edition.service.EditionLocalServiceUtil;
import eu.strasbourg.service.official.model.Official;
import eu.strasbourg.service.official.service.OfficialLocalServiceUtil;
import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.service.place.service.PlaceLocalServiceUtil;
import eu.strasbourg.service.project.model.BudgetParticipatif;
import eu.strasbourg.service.project.model.BudgetPhase;
import eu.strasbourg.service.project.model.Initiative;
import eu.strasbourg.service.project.model.Participation;
import eu.strasbourg.service.project.model.Petition;
import eu.strasbourg.service.project.model.Project;
import eu.strasbourg.service.project.service.BudgetParticipatifLocalServiceUtil;
import eu.strasbourg.service.project.service.BudgetPhaseLocalServiceUtil;
import eu.strasbourg.service.project.service.InitiativeLocalServiceUtil;
import eu.strasbourg.service.project.service.ParticipationLocalServiceUtil;
import eu.strasbourg.service.project.service.PetitionLocalServiceUtil;
import eu.strasbourg.service.project.service.ProjectLocalServiceUtil;
import eu.strasbourg.service.search.log.model.SearchLog;
import eu.strasbourg.service.search.log.service.SearchLogLocalServiceUtil;
import eu.strasbourg.service.video.model.Video;
import eu.strasbourg.service.video.service.VideoLocalServiceUtil;
import eu.strasbourg.utils.AssetPublisherTemplateHelper;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.JournalArticleHelper;
import eu.strasbourg.utils.LayoutHelper;
import eu.strasbourg.utils.SearchHelper;
import eu.strasbourg.utils.api.FileEntryHelperService;
import eu.strasbourg.utils.api.LayoutHelperService;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Collator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/**
 * @author cedric.henry
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Strasbourg",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.css-class-wrapper=dynamic-search-asset-portlet",
		"javax.portlet.display-name=Recherche d'asset dynamique",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/dynamic-search-asset-view.jsp",
		"javax.portlet.name=" + StrasbourgPortletKeys.DYNAMIC_SEARCH_ASSET_WEB,
		"javax.portlet.init-param.config-template=/dynamic-search-asset-configuration.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DynamicSearchAssetWebPortlet extends MVCPortlet {

	/**
	 * Initialisation de la vue
	 */
	@Override
	public void render(RenderRequest request, RenderResponse response) throws IOException, PortletException {
		try {
			// Recuperation du contexte de la requete
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			DynamicSearchAssetConfiguration configuration = ConfigurationProviderUtil.getPortletInstanceConfiguration(DynamicSearchAssetConfiguration.class, themeDisplay);
			
			// Recuperation et attribution des informations de l'utilisateur
			String publikUserId = getPublikID(request);
			request.setAttribute("publikUserId", publikUserId);
			
			// Recuperation et attribution de l'URL de base du site
			String homeUrl = Utils.getHomeURL(themeDisplay);
			request.setAttribute("homeURL", homeUrl);


			Boolean isPublikLoggedin = (Boolean) themeDisplay.getRequest().getSession().getAttribute("publik_logged_in");
			request.setAttribute("isPublikLoggedin", isPublikLoggedin != null && isPublikLoggedin);

			String currentUrl = themeDisplay.getPortalURL() + themeDisplay.getURLCurrent();
			String dashboardURL = _layoutHelperService.getDashboardURL();
			request.setAttribute("dashboardURL", dashboardURL);

			String publikLoginURL = _layoutHelperService.getPublikLoginURL(currentUrl);
			request.setAttribute("publikLoginURL", publikLoginURL);

			String publikLogoutURL = _layoutHelperService.getPublikLogoutURL(currentUrl);
			request.setAttribute("publikLogoutURL", publikLogoutURL);

			if(isPublikLoggedin != null && isPublikLoggedin) {
				String publikName = themeDisplay.getRequest().getSession().getAttribute("publik_given_name") + " " + themeDisplay.getRequest().getSession().getAttribute("publik_family_name").toString().charAt(0);
				request.setAttribute("publikName", publikName);
			}

			
			// Recuperation du formulaire configuré
			String searchForm = configuration.searchForm();
			request.setAttribute("searchForm", searchForm);
			
			// Recuperation du type de recherche
			Boolean dynamicSearch = configuration.dynamicSearch();
			request.setAttribute("dynamicSearch", dynamicSearch);
			
			// Recuperation des classes demandees
			List<String> classNames = this.getConfiguredClassNamesList(configuration);
			request.setAttribute("classNames", classNames);

			// Retourne le delta
			request.setAttribute("delta", configuration.delta());
			
		} catch (ConfigurationException e) {
			_log.error(e.getMessage(), e);
		}
		
		super.render(request, response);
	}
	
	/**
	 * Méthode exécutée lors d'un appel AJAX
	 * Chaque appel est identifié par un RessourceID permettant de gérer le comportement 
	 * à fourir
	 * @note Il est possible de gérer chaque fonction dans une classe MVCRessourceCommand
	 * 		comme dans les modules BO pour les MVCActionCommand, toutefois il faudrait mutualiser
	 * 		les données dans une classe externe pour agir sur les même résultats 
	 */
	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response)
			throws IOException, PortletException {
		try {
			// Recuperation du contexte de la requete
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			DynamicSearchAssetConfiguration configuration = ConfigurationProviderUtil.getPortletInstanceConfiguration(DynamicSearchAssetConfiguration.class, themeDisplay);
			long groupId = themeDisplay.getLayout().getGroupId();
			String resourceID = request.getResourceID();	
			
			// ---------------------------------------------------------------
			// -------- REQUETE : Effectuer une recherche --------------------
			// ---------------------------------------------------------------
			if (resourceID.equals("searchSubmit")) {
				
				// Recuperation du searchContext
				HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(request);
				SearchContext searchContext = SearchContextFactory.getInstance(servletRequest);
				
				// Recuperation des classNames selectionnes demandes par l'utilisateur
				String[] classNames;
				String selectedClassNames = ParamUtil.getString(request, "selectedClassNames");
				if(Validator.isNotNull(selectedClassNames))
					classNames = selectedClassNames.split(",");
				else {
					// si le paramètre n'existe pas on prend les className de la configuration
					String configurationClassNames = this.getConfiguredClassNames(configuration);
					classNames = configurationClassNames.split(",");
				}

				// Recuperation des mots clefs demandes par l'utilisateur
				String keywords = ParamUtil.getString(request, "keywords");
				
				// Inclusion ou non du scope global
				boolean globalScope = configuration.globalScope();
				long globalGroupId = themeDisplay.getCompanyGroupId();
				
				// Recuperation du nombre de resultat max demande
				int maxResults = (int) configuration.delta();
				
				// Recuperation de la configuration du prefiltre par date de la configuration
				boolean useDatePrefilter = configuration.dateField();
				long dateRangeFrom = (int) configuration.dateRangeFrom();
				long dateRangeTo = (int) configuration.dateRangeTo();
				LocalDate fromDate = LocalDate.now().plusDays(dateRangeFrom);
				LocalDate toDate = LocalDate.now().plusDays(dateRangeTo);
				
				// Recuperation de la configuration des prefiltre sur les categories
				String prefilterCategoriesIdsString = configuration.prefilterCategoriesIds();
				List<Long[]> prefilterCategoriesIds = new ArrayList<>();
				for (String prefilterCategoriesIdsGroupByVocabulary : prefilterCategoriesIdsString.split(";")) {
					Long[] prefilterCategoriesIdsForVocabulary = ArrayUtil
							.toLongArray(StringUtil.split(prefilterCategoriesIdsGroupByVocabulary, ",", 0));
					prefilterCategoriesIds.add(prefilterCategoriesIdsForVocabulary);
				}
				
				// Recuperation de la configuration des prefiltre sur les etiquettes
				String prefilterTagsNamesString = configuration.prefilterTagsNames();
				String[] prefilterTagsNames = StringUtil.split(prefilterTagsNamesString);
				
				// Recherche
				Hits hits = SearchHelper.getGlobalSearchHits(searchContext, classNames, groupId, globalGroupId, globalScope,
						keywords, useDatePrefilter, "publishDate_sortable", fromDate, toDate, new ArrayList<>(),
						prefilterCategoriesIds, prefilterTagsNames, themeDisplay.getLocale(), 0,
						maxResults, "score", false);
				
				List<AssetEntry> results = new ArrayList<>();
				BudgetPhase activePhase = BudgetPhaseLocalServiceUtil.getActivePhase(groupId);
				AssetCategory activePhaseCategory = activePhase != null ? activePhase.getPhaseCategory() : null;
				long totalResult =0;
				if (hits != null) {
					int i = 0;
					for (float s : hits.getScores()) {
						_log.info(GetterUtil.getString(hits.getDocs()[i].get(Field.TITLE)) + " : " + s);
						i++;
						if (i > 10)
							break;
					}
					for (Document document : hits.getDocs()) {
						AssetEntry entry = AssetEntryLocalServiceUtil.fetchEntry(
								GetterUtil.getString(document.get(Field.ENTRY_CLASS_NAME)),
								GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));

						if (entry != null) {
							//On elimine tous les BP qui ne font pas parti de la phase active. Si pas de phase active, pas d'affichage des BP
							//C'est dommage de faire le filtrage après la recherche mais la configuration actuelle de la recherche ne permet pas
							//de préfiltrer sur la catégorie pour une seule entité en particuler
							if (document.get(Field.ENTRY_CLASS_NAME).equals("eu.strasbourg.service.project.model.BudgetParticipatif") &&
									(activePhaseCategory == null ||
											!AssetVocabularyHelper.hasAssetCategoryAssetEntry(entry.getEntryId(), activePhaseCategory.getCategoryId()))) {
								entry = null;
							}

							//On elimine tous les CW qui n'ont pas de layout
							if (document.get(Field.ENTRY_CLASS_NAME).equals(JournalArticle.class.getName())) {
								// on vérifie si le jourrnalArticle est utilisé
								try {
									JournalArticle journalArticle = JournalArticleServiceUtil.getLatestArticle(entry.getClassPK());
									String url = LayoutHelper.getJournalArticleLayoutURL(journalArticle.getGroupId(), journalArticle.getArticleId(), themeDisplay);
									if (Validator.isNull(url)) {
										entry = null;
									}
								} catch (PortalException e) {
									entry = null;
								}
							}
							if (entry != null) {
								results.add(entry);
							}
						}
					}
					totalResult = SearchHelper.getGlobalSearchCount(searchContext, classNames, groupId, globalGroupId,
							globalScope, keywords, useDatePrefilter, "publishDate_sortable", fromDate, toDate, new ArrayList<>(),
							prefilterCategoriesIds, prefilterTagsNames, themeDisplay.getLocale());
				}

				List<AssetEntry> assetEntries = results;
				
				this.applyTemplateBehaviors(configuration,assetEntries);

				JSONArray jsonResponse = this.constructJSONSelection(request, configuration,assetEntries,totalResult, keywords, (long) (hits.getSearchTime() * 1000));
				
				// Recuperation de l'élément d'écriture de la réponse
				PrintWriter writer = response.getWriter();
				writer.print(jsonResponse.toString());
			}else if(resourceID.equals("logChoice")){
				// On logue le choix de l'utilsateur
				long searchLogId = ParamUtil.getLong(request, "searchLogId");
				SearchLog searchLog = SearchLogLocalServiceUtil.fetchSearchLog(searchLogId);
				if (searchLog != null) {
					long userTargetClassId = ParamUtil.getLong(request, "classNameId");
					long userTargetClassPK = ParamUtil.getLong(request, "classPK");
					String userTargetTitle = ParamUtil.getString(request, "title");
					searchLog.setUserTargetClassId(userTargetClassId);
					searchLog.setUserTargetClassPK(userTargetClassPK);
					searchLog.setUserTargetTitle(userTargetTitle);
					SearchLogLocalServiceUtil.updateSearchLog(searchLog);
				}
			}
			
		} catch (Exception e) {
			_log.error(e);
		}
		super.serveResource(request, response);
	}
	
	/**
	 * Applique un comportement de filtrage suplémentaire selon le template 
	 * de formulaire configuré
	 */
	private void applyTemplateBehaviors(DynamicSearchAssetConfiguration configuration,List<AssetEntry> assetEntries) {
		
		String searchForm = configuration.searchForm();

		// Comportement(s) : Plateforme-Citoyenne
		if (Constants.SEARCH_FORM_PLACIT.equals(searchForm)) {// Parcours des résultats
			for (Iterator<AssetEntry> results = assetEntries.iterator(); results.hasNext(); ) {
				AssetEntry assetEntry = results.next();

				String assetClassName = assetEntry.getClassName();

				// Retirer les événements n'appartenant pas à Placit via le tag dédié
				if (assetClassName.equals(Event.class.getName())) {
					List<String> assetTags = Arrays.asList(assetEntry.getTagNames());

					if (!assetTags.contains(Constants.PLACIT_TAG)) {
						results.remove();
					}
				}

				// Retirer les vidéos n'appartenant pas à Placit via le tag dédié
				if (assetClassName.equals(Video.class.getName())) {
					List<String> assetTags = Arrays.asList(assetEntry.getTagNames());

					if (!assetTags.contains(Constants.PLACIT_TAG)) {
						results.remove();
					}
				}

			}
		}
	}
	
	/**
	 * Retourne un objet JSON contenant l'ensemble des entités voulues et valide
	 * un atribut "isMarkeable" à afficher sur la map en front
	 * @return JSONObject sous la forme :
	 * 		{
	 * 			"projects" : 
	 * 				[
     * 					{"id" : 0000,
	 * 					"title" : "blablabla"
	 * 					...},
	 *	  				{...}
	 * 				],
	 * 			"participations" :
	 * 				[{...}],
	 * 			"events" :
	 * 				[{...}],
	 * 		}
	 * @throws  PortalException
	 */
	@SuppressWarnings("JavaDoc")
	private JSONArray constructJSONSelection(ResourceRequest request, DynamicSearchAssetConfiguration configuration,List<AssetEntry> assetEntries,long totalResult,String keywords,long searchTime) throws PortalException {
		
		// Récupération du contexte de la requète
		String publikUserId = this.getPublikID(request);
		
		// Initialisation du JSON de réponse
		JSONArray jsonResponse = JSONFactoryUtil.createJSONArray();

		JSONObject jsonTotalResult = JSONFactoryUtil.createJSONObject();
		jsonTotalResult.put("totalResult", totalResult);
		jsonResponse.put(jsonTotalResult);

		JSONObject jsonDisplayResult = JSONFactoryUtil.createJSONObject();
		jsonDisplayResult.put("displayResult", configuration.delta());
		jsonResponse.put(jsonDisplayResult);

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		String configAffichage = configuration.searchForm();
		
		// Parcours des résultats
		for (AssetEntry assetEntry : assetEntries) {
			
			String assetClassName = assetEntry.getClassName();

			int descriptionMaxLength = configAffichage.equals("strasbourg")?100:-1;
			
			// Récupération du JSON de l'entité selon le type d'assetEntry
			// Note : impossibilité d'utilisé un switch case pour cause d'utilisation de non-constante
			// TODO : Trouver comment contrer l'archaïssité de java sur le sujet des constantes sur les switch
			// AssetEntry : Événement
			if (assetClassName.equals(Event.class.getName())) {
				Event event = EventLocalServiceUtil.getEvent(assetEntry.getClassPK());
				JSONObject jsonEvent = JSONSearchHelper.createEventSearchJson(event, getImageURL(event.getImageId()), locale, themeDisplay, publikUserId, configAffichage, descriptionMaxLength);
				jsonEvent = JSONSearchHelper.createAssetEntrySearchJson(jsonEvent, assetEntry);
				jsonResponse.put(jsonEvent);
			}
			
			// AssetEntry : Projet
			else if (assetClassName.equals(Project.class.getName())) {
				Project project = ProjectLocalServiceUtil.getProject(assetEntry.getClassPK());
				JSONObject jsonProject = JSONSearchHelper.createProjectSearchJson(project, getImageURL(project.getImageId()), themeDisplay, configAffichage, descriptionMaxLength);
				jsonProject = JSONSearchHelper.createAssetEntrySearchJson(jsonProject, assetEntry);
				jsonResponse.put(jsonProject);
			}

			// AssetEntry : Participation
			else if (assetClassName.equals(Participation.class.getName())) {
				Participation participation = ParticipationLocalServiceUtil.getParticipation(assetEntry.getClassPK());
				JSONObject jsonParticipation = JSONSearchHelper.createParticipationSearchJson(participation, locale, themeDisplay, configAffichage);
				jsonParticipation = JSONSearchHelper.createAssetEntrySearchJson(jsonParticipation, assetEntry);
				jsonResponse.put(jsonParticipation);
			}

			// AssetEntry : Vidéo
			else if (assetClassName.equals(Video.class.getName())) {
				Video video = VideoLocalServiceUtil.getVideo(assetEntry.getClassPK());
				JSONObject jsonVideo = JSONSearchHelper.createVideoSearchJson(video, getImageURL(video.getImageId()), locale, themeDisplay, configAffichage);
				jsonVideo = JSONSearchHelper.createAssetEntrySearchJson(jsonVideo, assetEntry);
				jsonResponse.put(jsonVideo);
			}

			// AssetEntry : Pétition
			else if (assetClassName.equals(Petition.class.getName())) {
				Petition petition = PetitionLocalServiceUtil.fetchPetition(assetEntry.getClassPK());
				JSONObject jsonPetition = JSONSearchHelper.createPetitionSearchJson(petition, getImageURL(petition.getImageId()), themeDisplay, configAffichage);
				jsonPetition = JSONSearchHelper.createAssetEntrySearchJson(jsonPetition, assetEntry);
				jsonResponse.put(jsonPetition);
			}
			
			// AssetEntry : Budget Participatif (Projet citoyen)
			else if (assetClassName.equals(BudgetParticipatif.class.getName())) {
				BudgetParticipatif bp = BudgetParticipatifLocalServiceUtil.fetchBudgetParticipatif(assetEntry.getClassPK());
				JSONObject jsonBP = JSONSearchHelper.createBudgetParticipatifSearchJson(bp, locale, themeDisplay, configAffichage);
				jsonBP = JSONSearchHelper.createAssetEntrySearchJson(jsonBP, assetEntry);
				jsonResponse.put(jsonBP);
			}
			
			// AssetEntry : Initiatives
			else if (assetClassName.equals(Initiative.class.getName())) {
				Initiative initiative = InitiativeLocalServiceUtil.fetchInitiative(assetEntry.getClassPK());
				JSONObject jsonInitiative = JSONSearchHelper.createInitiativeSearchJson(initiative, getImageURL(initiative.getImageId()), themeDisplay, configAffichage);
				jsonInitiative = JSONSearchHelper.createAssetEntrySearchJson(jsonInitiative, assetEntry);
				jsonResponse.put(jsonInitiative);
			}
			
			// AssetEntry : JournalArticle avant identification d'un potentiel Article
			else if (assetClassName.equals(JournalArticle.class.getName())) {
				String[] tagNames = assetEntry.getTagNames();

				// Outil permettant de passer outre les accents lors d'un test d'équivalence
				Collator collator = Collator.getInstance();
				collator.setStrength(Collator.NO_DECOMPOSITION);
				boolean containsNewsTagName = false;

				// Vérification de la véracité d'un JournalArticle de type actualité pour placit
				for (String nameToTest : tagNames) {
					if (collator.compare(nameToTest, Constants.NEWS_TAG_NAME) == 0 || collator.compare(nameToTest, Constants.ARTICLES_TAG_NAME) == 0) {
						containsNewsTagName = true;
					}
				}

				// Si tel est le cas
				if (containsNewsTagName || !configAffichage.equals(Constants.SEARCH_FORM_PLACIT)) {
					try {
						JournalArticle journalArticle = JournalArticleServiceUtil.getLatestArticle(assetEntry.getClassPK());
						String documentStructure = JournalArticleHelper.getJournalArticleFieldValue(journalArticle, "thumbnail", locale);
						// Parse les données JSON
						JSONObject documentJSONObject = JSONFactoryUtil.createJSONObject(documentStructure);

						JSONObject jsonArticle = JSONSearchHelper.createJournalArticleSearchJson(assetEntry, journalArticle, getImageURL(documentJSONObject.getLong("fileEntryId")), locale, themeDisplay, configAffichage, descriptionMaxLength, publikUserId);
						jsonArticle = JSONSearchHelper.createAssetEntrySearchJson(jsonArticle, assetEntry);
						jsonResponse.put(jsonArticle);
					}catch (Exception e){
						_log.error(e);
					}
				}
			}

			// AssetEntry : Official
			else if (assetClassName.equals(Official.class.getName())) {
				Official official = OfficialLocalServiceUtil.getOfficial(assetEntry.getClassPK());
				JSONObject jsonOfficial = JSONSearchHelper.createOfficialSearchJson(official, getImageURL(official.getImageId()), locale, themeDisplay, configAffichage);
				jsonOfficial = JSONSearchHelper.createAssetEntrySearchJson(jsonOfficial, assetEntry);
				jsonResponse.put(jsonOfficial);
			}

			// AssetEntry : Edition
			else if (assetClassName.equals(Edition.class.getName())) {
				Edition edition = EditionLocalServiceUtil.getEdition(assetEntry.getClassPK());
				JSONObject jsonEdition = JSONSearchHelper.createEditionSearchJson(edition, getImageURL(edition.getImageId()), locale, themeDisplay, configAffichage, descriptionMaxLength, publikUserId);
				jsonEdition = JSONSearchHelper.createAssetEntrySearchJson(jsonEdition, assetEntry);
				jsonResponse.put(jsonEdition);
			}

			// AssetEntry : Manifestation
			else if (assetClassName.equals(Manifestation.class.getName())) {
				Manifestation manifestation = ManifestationLocalServiceUtil.getManifestation(assetEntry.getClassPK());
				JSONObject jsonManifestation = JSONSearchHelper.createManifestationSearchJson(manifestation, locale, themeDisplay, configAffichage, descriptionMaxLength);
				jsonManifestation = JSONSearchHelper.createAssetEntrySearchJson(jsonManifestation, assetEntry);
				jsonResponse.put(jsonManifestation);
			}

			// AssetEntry : EditionGallery
			else if (assetClassName.equals(EditionGallery.class.getName())) {
				EditionGallery editionGallery = EditionGalleryLocalServiceUtil.getEditionGallery(assetEntry.getClassPK());
				JSONObject jsonEditionGallery = JSONSearchHelper.createEditionGallerySearchJson(editionGallery, getImageURL(editionGallery.getImageId()), locale, themeDisplay, configAffichage, descriptionMaxLength);
				jsonEditionGallery = JSONSearchHelper.createAssetEntrySearchJson(jsonEditionGallery, assetEntry);
				jsonResponse.put(jsonEditionGallery);
			}

			// AssetEntry : Place
			else if (assetClassName.equals(Place.class.getName())) {
				Place place = PlaceLocalServiceUtil.getPlace(assetEntry.getClassPK());
				JSONObject jsonPlace = JSONSearchHelper.createPlaceSearchJson(place, getImageURL(place.getImageId()), locale, themeDisplay, configAffichage, publikUserId);
				jsonPlace = JSONSearchHelper.createAssetEntrySearchJson(jsonPlace, assetEntry);
				jsonResponse.put(jsonPlace);
			}

			// AssetEntry : ActivityCourse
			else if (assetClassName.equals(ActivityCourse.class.getName())) {
				ActivityCourse activityCourse = ActivityCourseLocalServiceUtil.getActivityCourse(assetEntry.getClassPK());
				JSONObject jsonActivityCourse = JSONSearchHelper.createActivityCourseSearchJson(activityCourse, getImageURL(activityCourse.getImageId()), locale, themeDisplay, configAffichage);
				jsonActivityCourse = JSONSearchHelper.createAssetEntrySearchJson(jsonActivityCourse, assetEntry);
				jsonResponse.put(jsonActivityCourse);
			}

			// AssetEntry : Activity
			else if (assetClassName.equals(Activity.class.getName())) {
				Activity activity = ActivityLocalServiceUtil.getActivity(assetEntry.getClassPK());
				JSONObject jsonActivity = JSONSearchHelper.createActivitySearchJson(activity, getImageURL(activity.getImageId()), locale, themeDisplay, configAffichage, descriptionMaxLength);
				jsonActivity = JSONSearchHelper.createAssetEntrySearchJson(jsonActivity, assetEntry);
				jsonResponse.put(jsonActivity);
			}
		}

		// Gestion du log
		JSONObject jsonSearchLog = JSONFactoryUtil.createJSONObject();
		ServiceContext sc = ServiceContextFactory.getInstance(request);
		AssetEntry result1 = assetEntries.size() > 0 ? assetEntries.get(0) : null;
		AssetEntry result2 = assetEntries.size() > 1 ? assetEntries.get(1) : null;
		AssetEntry result3 = assetEntries.size() > 2 ? assetEntries.get(2) : null;
		SearchLog searchLog = SearchLogLocalServiceUtil.addSearchLog(sc, keywords,
				totalResult, result1, result2, result3, null, searchTime);
		jsonSearchLog.put("searchLogId", searchLog.getSearchLogId());
		jsonResponse.put(jsonSearchLog);

		return  jsonResponse;
	}

	/**
	 * Retourne la liste des class names configurés recherchable
	 */
	public String getConfiguredClassNames(DynamicSearchAssetConfiguration configuration) {
		String classNames = configuration.assetClassNames();
		if (configuration.searchNews()) {
			if (Validator.isNotNull(classNames)) {
				classNames += ",";
			}
			classNames += JournalArticle.class.getName();
		}
		if (configuration.searchDocument()) {
			if (Validator.isNotNull(classNames)) {
				classNames += ",";
			}
			classNames += DLFileEntry.class.getName();
		}
		return classNames;
	}

	/**
	 * Retourne la liste des class names configurés recherchable
	 */
	public List<String> getConfiguredClassNamesList(DynamicSearchAssetConfiguration configuration) {
		List<String> classNames = new ArrayList<String>(Arrays.asList(this.getConfiguredClassNames(configuration).split(",")));
		return classNames;
	}
	
	/**
	 * Récupération du publik ID avec la session
	 * @return L'id publik de l'utilisateur courant
	 */
	private String getPublikID(PortletRequest request) {
		LiferayPortletRequest liferayPortletRequest = PortalUtil.getLiferayPortletRequest(request);
		HttpServletRequest originalRequest = liferayPortletRequest.getHttpServletRequest();
		
		return SessionParamUtil.getString(originalRequest, "publik_internal_id");
	}

	private String getImageURL(long fileEntryId){
		if(Validator.isNotNull(fileEntryId)) {
			FileEntry fileEntry = FileEntryUtil.fetchByPrimaryKey(fileEntryId);
			if(Validator.isNotNull(fileEntry)) {
				return fileEntryHelperService.getClosestSizeImageURL(fileEntry, 100);
			}else{
				_log.warn("DynamicSearchtAsset File not found : " + fileEntryId);
			}
		}
		return "";
	}

	@Reference
	public FileEntryHelperService fileEntryHelperService;

	@Reference
	private LayoutHelperService _layoutHelperService;

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
	
}