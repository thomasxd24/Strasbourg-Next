package eu.strasbourg.portlet.twitter;

import com.liferay.portal.configuration.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.twitter.configuration.TwitterConfiguration;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;
import java.util.ArrayList;

@Component(
	immediate = true,
	configurationPid = "eu.strasbourg.portlet.twitter.configuration.TwitterConfiguration",
	property = { "com.liferay.portlet.display-category=Strasbourg",
		"com.liferay.portlet.instanceable=true",
		"com.liferay.portlet.requires-namespaced-parameters=false",
		"com.liferay.portlet.css-class-wrapper=twitter-portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/twitter-view.jsp",
			"javax.portlet.init-param.config-template=/configuration/twitter-configuration.jsp",
			"javax.portlet.name=" + StrasbourgPortletKeys.TWITTER_WEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
			"javax.portlet.version=3.0"},
	service = Portlet.class)
public class TwitterPortlet extends MVCPortlet {

	private Log log = LogFactoryUtil.getLog(this.getClass());

	@Override
	public void render(RenderRequest renderRequest,
		RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
			.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			TwitterConfiguration configuration = ConfigurationProviderUtil.getPortletInstanceConfiguration(TwitterConfiguration.class, themeDisplay);


			// Compte Twitter
			String twitterAccount = configuration.twitterAccount();
			renderRequest.setAttribute("twitterAccount", twitterAccount);

			// Nombre de tweets à afficher
			long tweetCount = configuration.tweetCount();
			renderRequest.setAttribute("tweetCount", tweetCount);

//			List<Tweet> tweets = TwitterUtil.getUserTimeline(twitterAccount,
//				(int)tweetCount);
//			renderRequest.setAttribute("tweets", tweets);
			renderRequest.setAttribute("tweets", new ArrayList<>());

		} catch (ConfigurationException e) {
			log.error(e);
		}

		super.render(renderRequest, renderResponse);
	}

}