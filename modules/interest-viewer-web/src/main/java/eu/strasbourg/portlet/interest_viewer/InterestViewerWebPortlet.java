package eu.strasbourg.portlet.interest_viewer;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import eu.strasbourg.portlet.interest_viewer.configuration.InterestViewerConfiguration;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

/**
 * @author angelique.champougny
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=Strasbourg",
		"com.liferay.portlet.instanceable=false", "com.liferay.portlet.required-namespaced-parameters=false",
		"javax.portlet.display-name=interest-viewer-web Portlet", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/interest-viewer-view.jsp", 
		"javax.portlet.init-param.config-template=/configuration/interest-viewer-configuration.jsp",
		"javax.portlet.name=" + StrasbourgPortletKeys.INTEREST_VIEWER_WEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class InterestViewerWebPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			InterestViewerConfiguration configuration = themeDisplay.getPortletDisplay()
					.getPortletInstanceConfiguration(InterestViewerConfiguration.class);

			//récupère le type d'affichage
			String template = configuration.template();
			if (Validator.isNull(template)) {
				template = "liste";
			}
			//récupère le message si l'utilisateur n'a pas choisi de centres d'interêts
			String noInterest = "";
			Map<Locale, String> mapText = LocalizationUtil.getLocalizationMap(configuration.noInterestXML());
			for (Map.Entry<Locale, String> map : mapText.entrySet()) {
				if (themeDisplay.getLocale().toString().equals(map.getKey().toString())) {
					noInterest = HtmlUtil.unescape(map.getValue());
					break;
				}
			}
			
			InterestViewerDisplayContext dc = new InterestViewerDisplayContext(themeDisplay, request, template, noInterest);
			
			request.setAttribute("dc", dc);
			
			include("/templates/" + template + ".jsp", request, response);
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}