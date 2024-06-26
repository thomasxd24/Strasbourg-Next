package eu.strasbourg.portlet.form_send.configuration;

import com.liferay.dynamic.data.mapping.model.DDMFormInstance;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceLocalServiceUtil;
import com.liferay.portal.configuration.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.form_send.formulaire.Formulaire;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component(
        configurationPid = "eu.strasbourg.portlet.form_send.configuration.FormSendConfiguration",
        configurationPolicy = ConfigurationPolicy.OPTIONAL,
        immediate = true,
        property = {
                "javax.portlet.name=" + StrasbourgPortletKeys.FORM_SEND_WEB },
        service = ConfigurationAction.class)
public class FormSendConfigurationAction
        extends DefaultConfigurationAction {

    /**
     * Action : Sauvegarde de la configuration si on a validé le formulaire ou
     * envoi de la JSP des sélecteurs si on a changé la liste déroulante des
     * types d'entité
     */
    @Override
    public void processAction(PortletConfig portletConfig,
                              ActionRequest request, ActionResponse response) throws Exception {


        String cmd = ParamUtil.getString(request, "cmd");

        if (cmd.equals("update")) {

            // Titre
            String title = ParamUtil.getString(request, "title");
            setPreference(request, "title", title);

            // Nombre d'entrées à afficher
            String nbEntries = ParamUtil.getString(request, "nbEntries");
            setPreference(request, "nbEntries", nbEntries);

            // Message de modération
            String message = ParamUtil.getString(request, "message");
            setPreference(request, "message", message);

            // Formulaire sélectionnés
            String formInstanceId = ParamUtil.getString(request, "formInstanceId");
            setPreference(request, "formInstanceId", formInstanceId);

            // Champs selectionnés
            String fieldsSelectedString = "";
            String newLibsString = "";
            String[] fieldsSelected = ParamUtil.getStringValues(request, "fieldsSelected");
            for (int i = 0; i < fieldsSelected.length; i++) {
                String fieldSelectedString = fieldsSelected[i];
                boolean typeContenuSelected = Validator.isNotNull(fieldSelectedString)
                        && !fieldSelectedString.equals("false");
                if (typeContenuSelected) {
                    if (fieldsSelectedString.length() > 0) {
                        fieldsSelectedString += ",";
                    }
                    fieldsSelectedString += fieldSelectedString;

                    // récupération du nouveau libellé
                    String newLib = ParamUtil.getString(request, "newLib_" + fieldSelectedString);
                    if (newLibsString.length() > 0) {
                        newLibsString += ",";
                    }
                    newLibsString += "newLib_" + fieldSelectedString + "--" + newLib;
                }
            }
            setPreference(request, "fieldsSelected", fieldsSelectedString);
            setPreference(request, "newLibs", newLibsString);

            // Template à afficher
            String template = ParamUtil.getString(request, "template",
                    "general");
            setPreference(request, "template", template);

            // Tri par défaut
            String defaultSort = ParamUtil.getString(request,
                    "defaultSort");
            setPreference(request, "defaultSort", defaultSort);

        }
        super.processAction(portletConfig, request, response);
    }

    /**
     * Envoie à la JSP de configuration des informations nécessaires
     */
    @Override
    public void include(PortletConfig portletConfig, HttpServletRequest request,
                        HttpServletResponse response) throws Exception {
        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) request
                    .getAttribute(WebKeys.THEME_DISPLAY);
            FormSendConfiguration configuration =  ConfigurationProviderUtil.getPortletInstanceConfiguration(FormSendConfiguration.class, themeDisplay);

            // Titre
            String title;
            String titleParam = ParamUtil.getString(request,
                    "title");
            if (Validator.isNotNull(titleParam)) {
                title = titleParam;
            } else {
                title = configuration.title();
            }
            request.setAttribute("title", title);

            // Nombre d'entrées
            String nbEntries;
            String nbEntriesParam = ParamUtil.getString(request,
                    "nbEntries");
            if (Validator.isNotNull(nbEntriesParam)) {
                nbEntries = nbEntriesParam;
            } else {
                if(Validator.isNotNull(configuration.nbEntries())) {
                    nbEntries = configuration.nbEntries();
                }else{
                    nbEntries = "5";
                }
            }
            request.setAttribute("nbEntries", nbEntries);

            // Message de modération
            String message;
            String messageParam = ParamUtil.getString(request,
                    "message");
            if (Validator.isNotNull(messageParam)) {
                message = messageParam;
            } else {
                message = configuration.message();
            }
            request.setAttribute("message", message);

            // Formulaires disponibles
            List<Formulaire> formulaireList = new ArrayList<Formulaire>();
            List<DDMFormInstance> formulaires = DDMFormInstanceLocalServiceUtil.getDDMFormInstances(-1, -1);
            formulaires = formulaires.stream().filter(f->f.getGroupId() == themeDisplay.getScopeGroupId()).collect(Collectors.toList());
            for (DDMFormInstance formulaire : formulaires) {
                DDMStructure structure = formulaire.getStructure();
                JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
                if(Validator.isNotNull(structure)){
                    jsonArray = JSONFactoryUtil.createJSONObject(structure.getDefinition()).getJSONArray("fields");
                }
                Formulaire form = new Formulaire(formulaire.getFormInstanceId(), formulaire.getNameMap(), jsonArray);
                formulaireList.add(form);
            }
            request.setAttribute("formulaireList", formulaireList);

            // Formulaire sélectionnés
            long[] formInstanceId = ParamUtil.getLongValues(request,
                    "formInstanceId");
            String formInstanceIdString;
            if (formInstanceId.length > 0) {
                formInstanceIdString = StringUtil.merge(formInstanceId);
            } else {
                formInstanceIdString = configuration.formInstanceId();
            }
            request.setAttribute("formInstanceId", formInstanceIdString);

            // Champs selectionnés
            String[] fieldsSelected = ParamUtil.getStringValues(request, "fieldsSelected");
            String fieldsSelectedString;
            String newLibsString = "";
            if (fieldsSelected.length > 0) {
                fieldsSelectedString = StringUtil.merge(fieldsSelected);

                // nouveaux libellés
                for (int i = 0; i < fieldsSelected.length; i++) {
                    String fieldSelectedString = fieldsSelected[i];
                    boolean typeContenuSelected = Validator.isNotNull(fieldSelectedString)
                            && !fieldSelectedString.equals("false");
                    if (typeContenuSelected) {
                        String newLib = ParamUtil.getString(request, "newLib_" + fieldSelectedString);
                        if (newLibsString.length() > 0) {
                            newLibsString += ",";
                        }
                        newLibsString += "newLib_" + fieldSelectedString + "--" + newLib;
                    }
                }
            } else {
                fieldsSelectedString = configuration.fieldsSelected();
                // nouveaux libellés
                newLibsString = configuration.newLibs();
            }
            request.setAttribute("fieldsSelected", fieldsSelectedString);
            request.setAttribute("newLibs", newLibsString);

            // Template à afficher
            String template = ParamUtil.getString(request, "template", configuration.template());
            request.setAttribute("template", template);

            // Tri par défaut
            String defaultSort = configuration.defaultSort();
            request.setAttribute("defaultSort", defaultSort);

        } catch (ConfigurationException e) {
            _log.error(e);
        }
        super.include(portletConfig, request, response);
    }

    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}
