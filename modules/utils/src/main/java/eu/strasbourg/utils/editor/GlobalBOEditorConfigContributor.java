package eu.strasbourg.utils.editor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.item.selector.ItemSelector;
import com.liferay.item.selector.ItemSelectorCriterion;
import com.liferay.item.selector.ItemSelectorReturnType;
import com.liferay.item.selector.criteria.FileEntryItemSelectorReturnType;
import com.liferay.item.selector.criteria.URLItemSelectorReturnType;
import com.liferay.item.selector.criteria.file.criterion.FileItemSelectorCriterion;
import com.liferay.portal.kernel.editor.configuration.BaseEditorConfigContributor;
import com.liferay.portal.kernel.editor.configuration.EditorConfigContributor;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;

import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

@Component(
	property = { "editor.name=ckeditor",
		"javax.portlet.name=com_liferay_journal_web_portlet_JournalPortlet",
		"javax.portlet.name=" + StrasbourgPortletKeys.ARTWORK_BO,
		"javax.portlet.name=" + StrasbourgPortletKeys.EDITION_BO,
		"javax.portlet.name=" + StrasbourgPortletKeys.AGENDA_BO,
		"javax.portlet.name=" + StrasbourgPortletKeys.LINK_BO,
		"javax.portlet.name=" + StrasbourgPortletKeys.VIDEO_BO,
		"javax.portlet.name=" + StrasbourgPortletKeys.PLACE_BO,
		"javax.portlet.name=" + StrasbourgPortletKeys.OFFICIAL_BO,
		"javax.portlet.name=" + StrasbourgPortletKeys.ACTIVITY_BO,
		"javax.portlet.name=" + StrasbourgPortletKeys.ACTIVITY_SEARCH_WEB,
		"javax.portlet.name=" + StrasbourgPortletKeys.PLACE_SCHEDULE_WEB },
	service = EditorConfigContributor.class)
public class GlobalBOEditorConfigContributor
	extends BaseEditorConfigContributor {

	private ItemSelector _itemSelector;

	@Override
	public void populateConfigJSONObject(JSONObject jsonObject,
		Map<String, Object> inputEditorTaglibAttributes,
		ThemeDisplay themeDisplay,
		RequestBackedPortletURLFactory requestBackedPortletURLFactory) {

		// Barres d'outil
		JSONArray toolbarConfiguration = jsonObject
			.getJSONArray("toolbar_liferay");
		JSONArray toolbarExtension = JSONFactoryUtil.createJSONArray();
		toolbarExtension.put("Copyright");
		toolbarExtension.put("FileSelector");
		toolbarConfiguration.put(toolbarExtension);
		jsonObject.put("toolbar_phone", toolbarConfiguration);
		jsonObject.put("toolbar_simple", toolbarConfiguration);
		jsonObject.put("allowedContent", true);

		// Plugins
		String extraPlugins = jsonObject.getString("extraPlugins");

		if (Validator.isNull(extraPlugins)) {
			extraPlugins = "copyright,fileselector";
		} else {
			if (!extraPlugins.contains("copyright")) {
				extraPlugins = extraPlugins + ",copyright";
			}
			if (!extraPlugins.contains("fileselector")) {
				extraPlugins = extraPlugins + ",fileselector";
			}
		}
		jsonObject.put("extraPlugins", extraPlugins);

		// Configuration ItemSelector
		List<ItemSelectorCriterion> itemSelectorCriteria = new ArrayList<>();

		List<ItemSelectorReturnType> desiredItemSelectorReturnTypes = new ArrayList<>();
		desiredItemSelectorReturnTypes
			.add(new FileEntryItemSelectorReturnType());
		FileItemSelectorCriterion fileItemSelectorCriterion = new FileItemSelectorCriterion();
		fileItemSelectorCriterion
			.setDesiredItemSelectorReturnTypes(desiredItemSelectorReturnTypes);

		itemSelectorCriteria.add(fileItemSelectorCriterion);

		PortletURL itemSelectorURL = getItemSelectorPortletURL(
			inputEditorTaglibAttributes, requestBackedPortletURLFactory,
			itemSelectorCriteria.toArray(
				new ItemSelectorCriterion[itemSelectorCriteria.size()]));

		if (itemSelectorURL != null) {
			jsonObject.put("filebrowserFileBrowseLinkUrl",
				itemSelectorURL.toString());
			jsonObject.put("filebrowserFileBrowseUrl",
				itemSelectorURL.toString());
		}

	}

	@Reference(unbind = "-")
	public void setItemSelector(ItemSelector itemSelector) {
		_itemSelector = itemSelector;
	}

	protected ItemSelector getItemSelector() {
		return _itemSelector;
	}

	private PortletURL getItemSelectorPortletURL(
		Map<String, Object> inputEditorTaglibAttributes,
		RequestBackedPortletURLFactory requestBackedPortletURLFactory,
		ItemSelectorCriterion... itemSelectorCriteria) {

		List<ItemSelectorReturnType> desiredItemSelectorReturnTypes = new ArrayList<>();

		desiredItemSelectorReturnTypes.add(new URLItemSelectorReturnType());

		for (ItemSelectorCriterion itemSelectorCriterion : itemSelectorCriteria) {

			itemSelectorCriterion.setDesiredItemSelectorReturnTypes(
				desiredItemSelectorReturnTypes);
		}

		String name = GetterUtil.getString(
			inputEditorTaglibAttributes.get("liferay-ui:input-editor:name"));

		boolean inlineEdit = GetterUtil.getBoolean(inputEditorTaglibAttributes
			.get("liferay-ui:input-editor:inlineEdit"));

		if (!inlineEdit) {
			String namespace = GetterUtil.getString(inputEditorTaglibAttributes
				.get("liferay-ui:input-editor:namespace"));

			name = namespace + name;
		}

		ItemSelector itemSelector = getItemSelector();

		return itemSelector.getItemSelectorURL(requestBackedPortletURLFactory,
			name + "selectItem", itemSelectorCriteria);
	}

}
