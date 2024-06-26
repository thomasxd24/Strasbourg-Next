
package eu.strasbourg.picker.taglib.entity.servlet.taglib;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.item.selector.ItemSelectorReturnType;
import com.liferay.item.selector.criteria.URLItemSelectorReturnType;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.taglib.util.IncludeTag;
import eu.strasbourg.picker.taglib.file.internal.servlet.ServletContextUtil;
import eu.strasbourg.portlet.activity.itemselector.ActivityCourseItemSelectorCriterion;
import eu.strasbourg.portlet.activity.itemselector.ActivityItemSelectorCriterion;
import eu.strasbourg.portlet.activity.itemselector.ActivityOrganizerItemSelectorCriterion;
import eu.strasbourg.portlet.activity.itemselector.AssociationItemSelectorCriterion;
import eu.strasbourg.portlet.activity.itemselector.PracticeItemSelectorCriterion;
import eu.strasbourg.portlet.agenda.itemselector.EventItemSelectorCriterion;
import eu.strasbourg.portlet.agenda.itemselector.ManifestationItemSelectorCriterion;
import eu.strasbourg.portlet.edition.itemselector.EditionGalleryItemSelectorCriterion;
import eu.strasbourg.portlet.edition.itemselector.EditionItemSelectorCriterion;
import eu.strasbourg.portlet.gtfs.itemselector.ArretItemSelectorCriterion;
import eu.strasbourg.portlet.gtfs.itemselector.LigneItemSelectorCriterion;
import eu.strasbourg.portlet.help.itemselector.HelpProposalItemSelectorCriterion;
import eu.strasbourg.portlet.link.itemselector.LinkItemSelectorCriterion;
import eu.strasbourg.portlet.official.itemselector.OfficialItemSelectorCriterion;
import eu.strasbourg.portlet.place.itemselector.PlaceItemSelectorCriterion;
import eu.strasbourg.portlet.project.itemselector.*;
import eu.strasbourg.portlet.video.itemselector.VideoGalleryItemSelectorCriterion;
import eu.strasbourg.portlet.video.itemselector.VideoItemSelectorCriterion;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Benjamin Bini
 */
public class EntityPickerTag extends IncludeTag {

	public void setName(String name) {
		_name = name;
	}

	public void setLabel(String label) {
		_label = label;
	}

	public void setRequired(String required) {
		_required = required;
	}

	public void setValue(String value) {
		_value = value;
	}

	public void setMultiple(String multiple) {
		_multiple = multiple;
	}

	public void setType(String type) {
		_type = type;
	}

	public void setGlobal(String global) {
		_global = global;
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);

		setServletContext(ServletContextUtil.getServletContext());
	}

	@Override
	protected void cleanUp() {
		_name = null;
	}

	@Override
	protected String getPage() {
		return _PAGE;
	}

	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("name", _name);
		request.setAttribute("label", _label);
		request.setAttribute("required", "true".equals(_required));
		request.setAttribute("value", "0".equals(_value) ? "" : _value);
		request.setAttribute("multiple", "true".equals(_multiple));
		request.setAttribute("type", _type);
		request.setAttribute("global", "true".equals(_global));

		// Entities
		List<AssetEntry> entities = new ArrayList<>();

		for (String entityId : _value.split(",")) {
			if (Validator.isNumber(entityId) && Long.parseLong(entityId) > 0) {
				AssetEntry entry;
				try {
					entry = AssetEntryLocalServiceUtil.getEntry(_type,
						Long.parseLong(entityId));
					if (entry != null) {
						entities.add(entry);
					}
				} catch (Exception e) {
					_log.error(e);
				}
			}
		}
		request.setAttribute("entities", entities);

		List<ItemSelectorReturnType> desiredItemSelectorReturnTypes = new ArrayList<>();
		desiredItemSelectorReturnTypes.add(new URLItemSelectorReturnType());

		PortletURL itemSelectorURL = null;
		switch (_type) {
		case "eu.strasbourg.service.edition.model.Edition":
			EditionItemSelectorCriterion editionItemSelectorCriterion = new EditionItemSelectorCriterion();
			editionItemSelectorCriterion.setDesiredItemSelectorReturnTypes(
				desiredItemSelectorReturnTypes);
			itemSelectorURL = ServletContextUtil.getItemSelector()
				.getItemSelectorURL(
					RequestBackedPortletURLFactoryUtil.create(request),
					"itemSelected" + _name, editionItemSelectorCriterion);
			break;
		case "eu.strasbourg.service.edition.model.EditionGallery":
			EditionGalleryItemSelectorCriterion editionGalleryItemSelectorCriterion = new EditionGalleryItemSelectorCriterion();
			editionGalleryItemSelectorCriterion
				.setDesiredItemSelectorReturnTypes(
					desiredItemSelectorReturnTypes);
			itemSelectorURL = ServletContextUtil.getItemSelector()
				.getItemSelectorURL(
					RequestBackedPortletURLFactoryUtil.create(request),
					"itemSelected" + _name,
					editionGalleryItemSelectorCriterion);
			break;
		case "eu.strasbourg.service.video.model.Video":
			VideoItemSelectorCriterion videoItemSelectorCriterion = new VideoItemSelectorCriterion();
			videoItemSelectorCriterion.setDesiredItemSelectorReturnTypes(
				desiredItemSelectorReturnTypes);
			itemSelectorURL = ServletContextUtil.getItemSelector()
				.getItemSelectorURL(
					RequestBackedPortletURLFactoryUtil.create(request),
					"itemSelected" + _name, videoItemSelectorCriterion);
			break;
		case "eu.strasbourg.service.video.model.VideoGallery":
			VideoGalleryItemSelectorCriterion videoGalleryItemSelectorCriterion = new VideoGalleryItemSelectorCriterion();
			videoGalleryItemSelectorCriterion.setDesiredItemSelectorReturnTypes(
				desiredItemSelectorReturnTypes);
			itemSelectorURL = ServletContextUtil.getItemSelector()
				.getItemSelectorURL(
					RequestBackedPortletURLFactoryUtil.create(request),
					"itemSelected" + _name, videoGalleryItemSelectorCriterion);
			break;
		case "eu.strasbourg.service.agenda.model.Event":
			EventItemSelectorCriterion eventItemSelectorCriterion = new EventItemSelectorCriterion();
			eventItemSelectorCriterion.setDesiredItemSelectorReturnTypes(
				desiredItemSelectorReturnTypes);
			itemSelectorURL = ServletContextUtil.getItemSelector()
				.getItemSelectorURL(
					RequestBackedPortletURLFactoryUtil.create(request),
					"itemSelected" + _name, eventItemSelectorCriterion);
			break;
		case "eu.strasbourg.service.agenda.model.Manifestation":
			ManifestationItemSelectorCriterion manifestationItemSelectorCriterion = new ManifestationItemSelectorCriterion();
			manifestationItemSelectorCriterion
				.setDesiredItemSelectorReturnTypes(
					desiredItemSelectorReturnTypes);
			itemSelectorURL = ServletContextUtil.getItemSelector()
				.getItemSelectorURL(
					RequestBackedPortletURLFactoryUtil.create(request),
					"itemSelected" + _name, manifestationItemSelectorCriterion);
			break;
		case "eu.strasbourg.service.link.model.Link":
			LinkItemSelectorCriterion linkItemSelectorCriterion = new LinkItemSelectorCriterion();
			linkItemSelectorCriterion
				.setDesiredItemSelectorReturnTypes(
					desiredItemSelectorReturnTypes);
			itemSelectorURL = ServletContextUtil.getItemSelector()
				.getItemSelectorURL(
					RequestBackedPortletURLFactoryUtil.create(request),
					"itemSelected" + _name, linkItemSelectorCriterion);
			break;
		case "eu.strasbourg.service.place.model.Place":
			PlaceItemSelectorCriterion placeItemSelectorCriterion = new PlaceItemSelectorCriterion();
			placeItemSelectorCriterion
				.setDesiredItemSelectorReturnTypes(
					desiredItemSelectorReturnTypes);
			itemSelectorURL = ServletContextUtil.getItemSelector()
				.getItemSelectorURL(
					RequestBackedPortletURLFactoryUtil.create(request),
					"itemSelected" + _name, placeItemSelectorCriterion);
			break;
		case "eu.strasbourg.service.activity.model.Activity":
			ActivityItemSelectorCriterion activityItemSelectorCriterion = new ActivityItemSelectorCriterion();
			activityItemSelectorCriterion
				.setDesiredItemSelectorReturnTypes(
					desiredItemSelectorReturnTypes);
			itemSelectorURL = ServletContextUtil.getItemSelector()
				.getItemSelectorURL(
					RequestBackedPortletURLFactoryUtil.create(request),
					"itemSelected" + _name, activityItemSelectorCriterion);
			break;
		case "eu.strasbourg.service.activity.model.ActivityCourse":
			ActivityCourseItemSelectorCriterion activityCourseItemSelectorCriterion = new ActivityCourseItemSelectorCriterion();
			activityCourseItemSelectorCriterion
				.setDesiredItemSelectorReturnTypes(
					desiredItemSelectorReturnTypes);
			itemSelectorURL = ServletContextUtil.getItemSelector()
				.getItemSelectorURL(
					RequestBackedPortletURLFactoryUtil.create(request),
					"itemSelected" + _name,
					activityCourseItemSelectorCriterion);
			break;
		case "eu.strasbourg.service.activity.model.ActivityOrganizer":
			ActivityOrganizerItemSelectorCriterion activityOrganizerItemSelectorCriterion = new ActivityOrganizerItemSelectorCriterion();
			activityOrganizerItemSelectorCriterion
				.setDesiredItemSelectorReturnTypes(
					desiredItemSelectorReturnTypes);
			itemSelectorURL = ServletContextUtil.getItemSelector()
				.getItemSelectorURL(
					RequestBackedPortletURLFactoryUtil.create(request),
					"itemSelected" + _name, activityOrganizerItemSelectorCriterion);
			break;
		case "eu.strasbourg.service.activity.model.Association":
			AssociationItemSelectorCriterion associationItemSelectorCriterion = new AssociationItemSelectorCriterion();
			associationItemSelectorCriterion
					.setDesiredItemSelectorReturnTypes(
							desiredItemSelectorReturnTypes);
			itemSelectorURL = ServletContextUtil.getItemSelector()
					.getItemSelectorURL(
							RequestBackedPortletURLFactoryUtil.create(request),
							"itemSelected" + _name, associationItemSelectorCriterion);
			break;
		case "eu.strasbourg.service.activity.model.Practice":
			PracticeItemSelectorCriterion practiceItemSelectorCriterion = new PracticeItemSelectorCriterion();
			practiceItemSelectorCriterion
					.setDesiredItemSelectorReturnTypes(
							desiredItemSelectorReturnTypes);
			itemSelectorURL = ServletContextUtil.getItemSelector()
					.getItemSelectorURL(
							RequestBackedPortletURLFactoryUtil.create(request),
							"itemSelected" + _name, practiceItemSelectorCriterion);
			break;
		case "eu.strasbourg.service.official.model.Official":
			OfficialItemSelectorCriterion officialItemSelectorCriterion = new OfficialItemSelectorCriterion();
			officialItemSelectorCriterion
				.setDesiredItemSelectorReturnTypes(
					desiredItemSelectorReturnTypes);
			itemSelectorURL = ServletContextUtil.getItemSelector()
				.getItemSelectorURL(
					RequestBackedPortletURLFactoryUtil.create(request),
					"itemSelected" + _name, officialItemSelectorCriterion);
			break;
		case "eu.strasbourg.service.project.model.Project":
			ProjectItemSelectorCriterion ProjectItemSelectorCriterion = new ProjectItemSelectorCriterion();
			ProjectItemSelectorCriterion
				.setDesiredItemSelectorReturnTypes(
					desiredItemSelectorReturnTypes);
			itemSelectorURL = ServletContextUtil.getItemSelector()
				.getItemSelectorURL(
					RequestBackedPortletURLFactoryUtil.create(request),
					"itemSelected" + _name, ProjectItemSelectorCriterion);
			break;
			case "eu.strasbourg.service.project.model.Participation":
				ParticipationItemSelectorCriterion ParticipationItemSelectorCriterion = new ParticipationItemSelectorCriterion();
				ParticipationItemSelectorCriterion
						.setDesiredItemSelectorReturnTypes(
								desiredItemSelectorReturnTypes);
				itemSelectorURL = ServletContextUtil.getItemSelector()
						.getItemSelectorURL(
								RequestBackedPortletURLFactoryUtil.create(request),
								"itemSelected" + _name, ParticipationItemSelectorCriterion);
				break;
			case "eu.strasbourg.service.project.model.Petition":
				PetitionItemSelectorCriterion PetitionItemSelectorCriterion = new PetitionItemSelectorCriterion();
				PetitionItemSelectorCriterion
						.setDesiredItemSelectorReturnTypes(
								desiredItemSelectorReturnTypes);
				itemSelectorURL = ServletContextUtil.getItemSelector()
						.getItemSelectorURL(
								RequestBackedPortletURLFactoryUtil.create(request),
								"itemSelected" + _name, PetitionItemSelectorCriterion);
				break;
			case "eu.strasbourg.service.project.model.SaisineObservatoire":
				SaisineObservatoireItemSelectorCriterion saisineObservatoireItemSelectorCriterion = new SaisineObservatoireItemSelectorCriterion();
				saisineObservatoireItemSelectorCriterion
						.setDesiredItemSelectorReturnTypes(
								desiredItemSelectorReturnTypes);
				itemSelectorURL = ServletContextUtil.getItemSelector()
						.getItemSelectorURL(
								RequestBackedPortletURLFactoryUtil.create(request),
								"itemSelected" + _name, saisineObservatoireItemSelectorCriterion);
				break;
			case "eu.strasbourg.service.project.model.BudgetParticipatif":
				BudgetParticipatifItemSelectorCriterion BudgetParticipatifItemSelectorCriterion = new BudgetParticipatifItemSelectorCriterion();
				BudgetParticipatifItemSelectorCriterion
						.setDesiredItemSelectorReturnTypes(
								desiredItemSelectorReturnTypes);
				itemSelectorURL = ServletContextUtil.getItemSelector()
						.getItemSelectorURL(
								RequestBackedPortletURLFactoryUtil.create(request),
								"itemSelected" + _name, BudgetParticipatifItemSelectorCriterion);
				break;
			case "eu.strasbourg.service.project.model.BudgetPhase":
				BudgetPhaseItemSelectorCriterion BudgetPhaseItemSelectorCriterion = new BudgetPhaseItemSelectorCriterion();
				BudgetPhaseItemSelectorCriterion
						.setDesiredItemSelectorReturnTypes(
								desiredItemSelectorReturnTypes);
				itemSelectorURL = ServletContextUtil.getItemSelector()
						.getItemSelectorURL(
								RequestBackedPortletURLFactoryUtil.create(request),
								"itemSelected" + _name, BudgetPhaseItemSelectorCriterion);
				break;
			case "eu.strasbourg.service.project.model.Initiative":
				InitiativeItemSelectorCriterion InitiativeItemSelectorCriterion = new InitiativeItemSelectorCriterion();
				InitiativeItemSelectorCriterion
						.setDesiredItemSelectorReturnTypes(
								desiredItemSelectorReturnTypes);
				itemSelectorURL = ServletContextUtil.getItemSelector()
						.getItemSelectorURL(
								RequestBackedPortletURLFactoryUtil.create(request),
								"itemSelected" + _name, InitiativeItemSelectorCriterion);
				break;
			case "eu.strasbourg.service.gtfs.model.Arret":
				ArretItemSelectorCriterion arretItemSelectorCriterion = new ArretItemSelectorCriterion();
				arretItemSelectorCriterion
						.setDesiredItemSelectorReturnTypes(
								desiredItemSelectorReturnTypes);
				itemSelectorURL = ServletContextUtil.getItemSelector()
						.getItemSelectorURL(
								RequestBackedPortletURLFactoryUtil.create(request),
								"itemSelected" + _name, arretItemSelectorCriterion);
				break;
			case "eu.strasbourg.service.gtfs.model.Ligne":
				LigneItemSelectorCriterion ligneItemSelectorCriterion = new LigneItemSelectorCriterion();
				ligneItemSelectorCriterion
						.setDesiredItemSelectorReturnTypes(
								desiredItemSelectorReturnTypes);
				itemSelectorURL = ServletContextUtil.getItemSelector()
						.getItemSelectorURL(
								RequestBackedPortletURLFactoryUtil.create(request),
								"itemSelected" + _name, ligneItemSelectorCriterion);
				break;

			case "eu.strasbourg.service.help.model.HelpProposal":
				HelpProposalItemSelectorCriterion helpProposalItemSelectorCriterion = new HelpProposalItemSelectorCriterion();
				helpProposalItemSelectorCriterion
						.setDesiredItemSelectorReturnTypes(
								desiredItemSelectorReturnTypes);
				itemSelectorURL = ServletContextUtil.getItemSelector()
						.getItemSelectorURL(
								RequestBackedPortletURLFactoryUtil.create(request),
								"itemSelected" + _name, helpProposalItemSelectorCriterion);
				break;
		}
		
		
		// Si l'attribut "global" est "true", on se met sur le groupe global en
		// modifiant l'URL
		itemSelectorURL.setParameter("multiple", _multiple);
		String itemSelectorURLString = itemSelectorURL.toString();
		if ("true".equals(this._global)) {	
			itemSelectorURLString = itemSelectorURLString.replaceAll("(?<=group).*(?=~)", "/global/");
		}
		request.setAttribute("itemSelectorURL", itemSelectorURLString);

	}

	private static final String _PAGE = "/entity/entity-picker-page.jsp";

	private String _label;
	private String _name;
	private String _required;
	private String _value;
	private String _multiple;
	private String _type;
	private String _global;

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}
