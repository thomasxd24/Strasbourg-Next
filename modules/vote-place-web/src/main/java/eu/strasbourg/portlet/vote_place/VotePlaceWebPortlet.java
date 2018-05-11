package eu.strasbourg.portlet.vote_place;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.SessionParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import eu.strasbourg.portlet.felec.portlet.FelecResponse;
import eu.strasbourg.portlet.felec.portlet.FelecWebServiceClient;
import eu.strasbourg.utils.PortletHelper;
import eu.strasbourg.utils.PublikApiClient;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

/**
 * @author angelique.champougny
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=Strasbourg",
		"com.liferay.portlet.instanceable=false", "com.liferay.portlet.required-namespaced-parameters=false",
		"javax.portlet.display-name=vote-place-web Portlet", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/vote-place-view.jsp",
		"javax.portlet.name=" + StrasbourgPortletKeys.VOTE_PLACE_WEB, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class VotePlaceWebPortlet extends MVCPortlet {
	private String address;

	@Override
	public void render(RenderRequest request, RenderResponse response) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		// récupération des infos de l'utilisateur
		String name = null;
		String firstName = null;
		String birthDate = null;
		String birthPlace = null;
		// Récupération du publik ID avec la session
		String internalId = getPublikID(request);
		if (Validator.isNotNull(internalId)) {
			JSONObject userDetail = PublikApiClient.getUserDetails(internalId);
			name = userDetail.getString("last_name");
			firstName = userDetail.getString("first_name");
			// date au format AAA-MM-JJ
			birthDate = userDetail.getString("birthdate");
			birthPlace = userDetail.getString("birthplace");
		}
		request.setAttribute("name", name);
		request.setAttribute("firstName", firstName);
		request.setAttribute("birthDate", birthDate);
		request.setAttribute("birthPlace", birthPlace);

		FelecResponse felecResponse = null;
		if (Validator.isNotNull(birthPlace) && Validator.isNotNull(birthDate)) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = sdf.parse(birthDate);
				felecResponse = FelecWebServiceClient.getResponse(name, firstName, date, birthPlace);
				request.setAttribute("felecResponse", felecResponse);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}else{
			List<String> champsNull = new ArrayList<String>();
			if (Validator.isNotNull(birthPlace)){
				champsNull.add("Ville de naissance");
			}
			if (Validator.isNotNull(birthDate)){
				champsNull.add("Date de naissance");
			}
			request.setAttribute("champsNull", champsNull);
		}

		super.render(request, response);
	}

	// Récupération de l'id utilisateur
	private String getPublikID(PortletRequest resourceRequest) {

		LiferayPortletRequest liferayPortletRequest = PortalUtil.getLiferayPortletRequest(resourceRequest);
		HttpServletRequest originalRequest = liferayPortletRequest.getHttpServletRequest();

		return SessionParamUtil.getString(originalRequest, "publik_internal_id");
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}