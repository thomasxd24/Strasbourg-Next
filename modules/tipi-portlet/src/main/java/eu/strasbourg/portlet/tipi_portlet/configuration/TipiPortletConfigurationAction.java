package eu.strasbourg.portlet.tipi_portlet.configuration;

import com.liferay.portal.configuration.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component(
	configurationPid = "eu.strasbourg.portlet.tipi_portlet.configuration.TipiPortletConfiguration",
	configurationPolicy = ConfigurationPolicy.OPTIONAL,
	immediate = true,
	property = {
		"javax.portlet.name=" + StrasbourgPortletKeys.TIPI_PORTLET_WEB },
	service = ConfigurationAction.class)
public class TipiPortletConfigurationAction
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

			// récupère le nom du formulaire
			String form = ParamUtil.getString(request, "form");
			setPreference(request, "form", form);
			
			// récupère le complément d'info du formulaire
			String complement = ParamUtil.getString(request, "complement");
			setPreference(request, "complement", complement);
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

			// Formulaire
			TipiPortletConfiguration configuration = ConfigurationProviderUtil.getPortletInstanceConfiguration(TipiPortletConfiguration.class, themeDisplay);

			request.setAttribute("form", configuration.form());
			request.setAttribute("complement", configuration.complement());

		} catch (ConfigurationException e) {
			_log.error(e);
		}
		super.include(portletConfig, request, response);
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}
