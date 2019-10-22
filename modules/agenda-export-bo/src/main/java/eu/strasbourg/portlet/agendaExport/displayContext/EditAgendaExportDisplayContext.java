package eu.strasbourg.portlet.agendaExport.displayContext;

import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.service.WorkflowDefinitionLinkLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.util.*;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import eu.strasbourg.service.agenda.model.AgendaExport;
import eu.strasbourg.service.agenda.model.AgendaExportPeriod;
import eu.strasbourg.service.agenda.service.AgendaExportLocalServiceUtil;
import eu.strasbourg.service.agenda.service.AgendaExportPeriodLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyAccessor;
import eu.strasbourg.utils.StrasbourgPropsUtil;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

public class EditAgendaExportDisplayContext {

    private ResourceBundle bundle = ResourceBundleUtil.getBundle("content.Language",
            this.getClass().getClassLoader());

	private final RenderRequest _request;
    private final ThemeDisplay _themeDisplay;
    private final AssetVocabularyAccessor _assetVocabularyAccessor;

    //View variables
    private AgendaExport _agendaExport;
    private Boolean _toExport = false;

    public EditAgendaExportDisplayContext(RenderRequest request, RenderResponse response) {
        this._request = request;
        this._themeDisplay = (ThemeDisplay) request
                .getAttribute(WebKeys.THEME_DISPLAY);
        _assetVocabularyAccessor = new AssetVocabularyAccessor();
    }

    /**
     * Retourne l'instance AgendaExport
     * @return
     */
    public AgendaExport getAgendaExport() {
        long agendaExportId = ParamUtil.getLong(_request, "agendaExportId");
        if (_agendaExport == null && agendaExportId > 0) {
        	_agendaExport = AgendaExportLocalServiceUtil.fetchAgendaExport(agendaExportId);
        }
        return _agendaExport;
    }

    public void setToExport(String export) {

        if(export.equals("true")) {
            _toExport = true;
        } else {
            _toExport = false;
        }
    }

    public Boolean getToExport() {
        return _toExport;
    }

    public List<AgendaExportPeriod> getOrCreateAgendaExportPeriods() throws PortalException {

        List<AgendaExportPeriod> periods = new ArrayList<>();
        if(_agendaExport == null || _agendaExport.getAgendaExportPeriods().isEmpty()) {
            periods.add(AgendaExportPeriodLocalServiceUtil.createAgendaExportPeriod());
        } else {
            periods = _agendaExport.getAgendaExportPeriods();
        }

        return periods;
    }

    /**
     * Retourne la liste des catégories sauvegardées en fonction du vocabulaire
     * @param vocabularyId
     * @return
     * @throws JSONException
     */
    public String getSavedCategoriesByVocabulary(String vocabularyId) throws JSONException {
        AgendaExport agendaExport = this.getAgendaExport();
        if(agendaExport == null) { return ""; }
        String categoriesString = agendaExport.getEventCategories();
        if(categoriesString == null) { return ""; }
        JSONObject vocabulaires = JSONFactoryUtil.createJSONObject(categoriesString);
        if(!vocabulaires.has(vocabularyId)) { return ""; }

        return vocabulaires.get(vocabularyId).toString();
    }

    public String getDefaultPeriodIndexes() {
        if (this.getAgendaExport() != null) {
            List<AgendaExportPeriod> periods = this.getAgendaExport().getAgendaExportPeriods();
            String indexes = "0";
            for (int i = 1; i <= periods.size(); i++) {
                indexes +=  "," + i;
            }
            return indexes;
        }
        return "";
    }

    public String getDefaultIndexes(int length) {
        String indexes = "";
        for (int i = 1; i <= length; i++) {
            if (Validator.isNotNull(indexes)) {
                indexes += ",";
            }
            indexes += i;
        }
        return indexes;
    }

    public Locale[] getAvailableLocales() {
        Set<Locale> availableLocalesSet = LanguageUtil.getSupportedLocales();
        return availableLocalesSet
                .toArray(new Locale[availableLocalesSet.size()]);
    }

    /**
     * Define the language filter list
     * @return
     */
    public List<String> getLanguageList() {
        List<String> languages = new ArrayList<>();
        languages.add(LanguageUtil.get(bundle, "eu.agenda.export.language.fr"));
        languages.add(LanguageUtil.get(bundle, "eu.agenda.export.language.en"));
        languages.add(LanguageUtil.get(bundle, "eu.agenda.export.language.de"));
        return languages;
    }

    /**
     * Define the language filter list
     * @return
     */
    public List<String> getFormatExportList() {
        List<String> languages = new ArrayList<>();

        languages.add(LanguageUtil.get(bundle, "eu.agenda.export.format.word"));
        languages.add(LanguageUtil.get(bundle, "eu.agenda.export.format.json"));
        return languages;
    }

    /**
     * Renvoit la liste des templates disponibles
     * @return
     */
    public List<String> getTemplateList() {

        String directoryPath = StrasbourgPropsUtil.getAgendaExportTemplateDirectory();
        File folder = new File(directoryPath);
        File[] filesList = folder.listFiles();
        List<String> filenames = new ArrayList<>();

        for (int i = 0; i < filesList.length; i++) {
            if (filesList[i].isFile()) {
                filenames.add(filesList[i].getName().replace(".docx",""));
            }
        }

        return filenames;

    }

    /**
     * Liste toutes les possibilitées de tri des templates
     * @return
     */
    public Map<String, String> getDataOrder() {
        Map<String, String> orders = new HashMap<>();
        orders.put("s", LanguageUtil.get(bundle, "eu.agenda.export.order.simple"));
        orders.put("gj", LanguageUtil.get(bundle, "eu.agenda.export.order.groupe.jour"));
        orders.put("gm", LanguageUtil.get(bundle, "eu.agenda.export.order.groupe.mois"));
        orders.put("gc", LanguageUtil.get(bundle, "eu.agenda.export.order.groupe.categorie"));
        orders.put("ggjc", LanguageUtil.get(bundle, "eu.agenda.export.order.sousgroupe.jour.categorie"));
        orders.put("ggcj", LanguageUtil.get(bundle, "eu.agenda.export.order.sousgroupe.categorie.jour"));
        orders.put("ggcm", LanguageUtil.get(bundle, "eu.agenda.export.order.sousgroupe.categorie.mois"));
        orders.put("ggmj", LanguageUtil.get(bundle, "eu.agenda.export.order.sousgroupe.mois.jour"));
        orders.put("ggmc", LanguageUtil.get(bundle, "eu.agenda.export.order.sousgroupe.mois.categorie"));
        return orders;
    }

    /**
     * Define the list of vocaularies that can be used as filter
     * @return
     */
    public List<AssetVocabulary> getEventVocabularies() {
        List<AssetVocabulary> vocabularies = new ArrayList<>();
        vocabularies.add(_assetVocabularyAccessor.getEventThemes());
        vocabularies.add(_assetVocabularyAccessor.getTerritories());
        vocabularies.add(_assetVocabularyAccessor.getEventPublics());
        vocabularies.add(_assetVocabularyAccessor.getEventTypes());
        vocabularies.add(_assetVocabularyAccessor.getPlaceTypes());
        return vocabularies;
    }

    /**
     * @return True si le framework workflow est actif pour ce type d'entité
     */
    public boolean isWorkflowEnabled() {
        boolean result = WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(
                _themeDisplay.getCompanyId(), _themeDisplay.getCompanyGroupId(),
                AgendaExport.class.getName());
        return result;
    }

    public boolean hasPermission(String actionId) {
        return _themeDisplay.getPermissionChecker().hasPermission(
                this._themeDisplay.getCompanyId(),
                StrasbourgPortletKeys.AGENDA_EXPORT_BO,
                StrasbourgPortletKeys.AGENDA_EXPORT_BO,
                actionId);
    }
}
