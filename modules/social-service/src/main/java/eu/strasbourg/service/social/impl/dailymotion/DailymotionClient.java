package eu.strasbourg.service.social.impl.dailymotion;

import com.liferay.portal.kernel.cache.PortalCacheHelperUtil;
import com.liferay.portal.kernel.cache.PortalCacheManagerNames;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import eu.strasbourg.service.social.SocialPost;
import eu.strasbourg.service.social.impl.SocialMedia;
import eu.strasbourg.service.social.instagram.DailymotionThumbnailRatio;
import eu.strasbourg.utils.JSONHelper;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DailymotionClient {

	private static Log log = LogFactoryUtil.getLog(DailymotionClient.class);

	public static List<SocialPost> getDailymotionVideos(String accountId,
		int count, DailymotionThumbnailRatio ratio) {

		Object timelineFromCache = PortalCacheHelperUtil
				.getPortalCache(PortalCacheManagerNames.MULTI_VM, "dailymotion_cache").get(accountId);
		Object lastTimelineUpdate = PortalCacheHelperUtil
			.getPortalCache(PortalCacheManagerNames.MULTI_VM, "dailymotion_cache").get(accountId + "_last_update");
		if (timelineFromCache != null && lastTimelineUpdate != null) {
			long now = new Date().getTime();
			long timeBeforeNextUpdate = 100
				- (now - ((Long) lastTimelineUpdate)) / 1000;
			if (timeBeforeNextUpdate > 0) {
				return (List<SocialPost>) timelineFromCache;
			}
		}
		
		Object[] stringData = { accountId, ratio.toString(), count };
		String apiURL = "https://api.dailymotion.com/user/%s/videos?fields=id,title,thumbnail_360_url,url,created_time&thumbnail_ratio=%s&limit=%s";
		apiURL = String.format(apiURL, stringData);

		List<SocialPost> videos = new ArrayList<SocialPost>();
		try {
			JSONObject json = JSONHelper.readJsonFromURL(apiURL);

			JSONArray jsonVideoList = json.getJSONArray("list");

			for (int i = 0; i < jsonVideoList.length(); i++) {
				SocialPost video = new SocialPost();
				video.setSocialMedia(SocialMedia.DAILYMOTION);
				//video.setUsername();

				JSONObject jsonVideo = jsonVideoList.getJSONObject(i);

				String imageURL = jsonVideo.getString("thumbnail_360_url");
				if (!imageURL.startsWith("https")) {
					imageURL = imageURL.replace("http", "https");
				}
				video.setImageURL(imageURL);

				String url = jsonVideo.getString("url");
				video.setUrl(url);

				long timestamp = jsonVideo.getLong("created_time");
				Date date = new Date(timestamp * 1000);
				video.setDate(date);

				videos.add(video);
			}
		} catch (JSONException | IOException e) {
			log.error(e);
		}

		PortalCacheHelperUtil.getPortalCache(PortalCacheManagerNames.MULTI_VM, "dailymotion_cache").remove(accountId);
		PortalCacheHelperUtil.getPortalCache(PortalCacheManagerNames.MULTI_VM, "dailymotion_cache")
			.remove(accountId + "_last_update");
		PortalCacheHelperUtil.getPortalCache(PortalCacheManagerNames.MULTI_VM, "dailymotion_cache").put(accountId,
			(Serializable) videos);
		PortalCacheHelperUtil.getPortalCache(PortalCacheManagerNames.MULTI_VM, "dailymotion_cache")
			.put(accountId + "_last_update", new Date().getTime());

		return videos;

	}

}
