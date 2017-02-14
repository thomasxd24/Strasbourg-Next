package eu.strasbourg.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;

public class JSONHelper {
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromURL(String URL)
		throws IOException, JSONException {
		InputStream is = new URL(URL).openStream();
		try {
			BufferedReader rd = new BufferedReader(
				new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = JSONFactoryUtil.createJSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	public static JSONObject getJSONFromI18nMap(Map<Locale, String> map) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		for (Map.Entry<Locale, String> entry : map.entrySet()) {
			json.put(entry.getKey().getLanguage(), entry.getValue());
		}
		return json;
	}
	
	public static JSONArray getEntityVocabularyJSON(String className, String vocabularyName, long groupId) {
		long classNameId = ClassNameLocalServiceUtil.getClassName(className).getClassNameId();
		List<AssetVocabulary> vocabularies = AssetVocabularyHelper.getVocabulariesForAssetType(groupId, classNameId);
		for (AssetVocabulary vocabulary : vocabularies) {
			if(StringHelper.compareIgnoringAccentuation(vocabulary.getName().toLowerCase(), vocabularyName)) {
				return AssetVocabularyHelper.toJSON(vocabulary);
			}
		}
		return JSONFactoryUtil.createJSONArray();
	}
}
