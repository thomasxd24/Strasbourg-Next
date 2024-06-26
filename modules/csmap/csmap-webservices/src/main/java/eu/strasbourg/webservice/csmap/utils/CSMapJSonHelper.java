package eu.strasbourg.webservice.csmap.utils;

import com.liferay.asset.category.property.model.AssetCategoryProperty;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.category.property.service.AssetCategoryPropertyLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.service.agenda.service.EventLocalServiceUtil;
import eu.strasbourg.service.favorite.model.Favorite;
import eu.strasbourg.service.favorite.model.FavoriteType;
import eu.strasbourg.service.gtfs.model.Arret;
import eu.strasbourg.service.gtfs.model.Direction;
import eu.strasbourg.service.gtfs.model.Ligne;
import eu.strasbourg.service.gtfs.service.ArretLocalServiceUtil;
import eu.strasbourg.service.gtfs.service.DirectionLocalServiceUtil;
import eu.strasbourg.service.gtfs.service.LigneLocalServiceUtil;
import eu.strasbourg.service.notif.model.ServiceNotif;
import eu.strasbourg.service.place.service.PlaceLocalServiceUtil;
import eu.strasbourg.utils.AssetPublisherTemplateHelper;
import eu.strasbourg.utils.JournalArticleHelper;
import eu.strasbourg.utils.StrasbourgPropsUtil;
import eu.strasbourg.utils.UriHelper;
import eu.strasbourg.webservice.csmap.constants.WSConstants;

import java.net.URISyntaxException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class CSMapJSonHelper {


    public static JSONObject getBreveCSMapJSON(JournalArticle breve) {
        JSONObject jsonJournalArticle = JSONFactoryUtil.createJSONObject();
        if (breve != null) {
            // Various-Data
            jsonJournalArticle.put(WSConstants.JSON_WC_ID, breve.getResourcePrimKey());
            DateFormat dateFormat = DateFormatFactoryUtil
                    .getSimpleDateFormat("dd/MM/yyyy");
            jsonJournalArticle.put(WSConstants.JSON_DATE, dateFormat.format(breve.getModifiedDate()));
            String image = JournalArticleHelper.getJournalArticleFieldValue(breve, "image", Locale.FRANCE);
            if(Validator.isNotNull(image)) {
                String imageURL = AssetPublisherTemplateHelper.getDocumentUrl(image);
                try{
                    jsonJournalArticle.put(WSConstants.JSON_WC_URL, UriHelper.appendUriImagePreview(StrasbourgPropsUtil.getBaseURL() + imageURL).toString());
                } catch (URISyntaxException e) {
                    jsonJournalArticle.put(WSConstants.JSON_WC_URL, StrasbourgPropsUtil.getBaseURL() + imageURL);
                }
            }

            JSONObject titles = JSONFactoryUtil.createJSONObject();
            String titleFR = JournalArticleHelper.getJournalArticleFieldValue(breve, "title", Locale.FRANCE);
            titles.put(WSConstants.JSON_LANGUAGE_FRANCE, titleFR);
            jsonJournalArticle.put(WSConstants.JSON_WC_TITLE, titles);

            JSONObject subTitles = JSONFactoryUtil.createJSONObject();
            String subTitleFR = JournalArticleHelper.getJournalArticleFieldValue(breve, "chapo", Locale.FRANCE);
            subTitles.put(WSConstants.JSON_LANGUAGE_FRANCE, subTitleFR);
            jsonJournalArticle.put(WSConstants.JSON_SUBTITLE, subTitles);

            JSONObject descriptions = JSONFactoryUtil.createJSONObject();
            String descriptionFR = JournalArticleHelper.getJournalArticleFieldValue(breve, "content", Locale.FRANCE);
            descriptions.put(WSConstants.JSON_LANGUAGE_FRANCE, descriptionFR);
            jsonJournalArticle.put(WSConstants.JSON_DESCRIPTION, descriptions);
        }
        return  jsonJournalArticle;
    }

    // Fonction permettant la creation des parties dans le JSON
    public static JSONObject emergencyCSMapJSON(List<JournalArticle> emergencyNumbers, Map<AssetCategory, List<JournalArticle>> emergencyHelpsMap) throws PortalException {
        JSONObject jsonEmergency = JSONFactoryUtil.createJSONObject();
        JSONArray emergencyNumbersJSON = JSONFactoryUtil.createJSONArray();
        JSONArray emergencyHelpsJSON = JSONFactoryUtil.createJSONArray();
        for(JournalArticle emergencyNumber : emergencyNumbers){
            JSONObject emergencyNumberJson = JSONFactoryUtil.createJSONObject();
            emergencyNumberJson.put("id", emergencyNumber.getResourcePrimKey());
            // CategoryTitle en fonction des differentes langues
            JSONObject titleJSON = JSONFactoryUtil.createJSONObject();
            titleJSON.put("fr_FR", JournalArticleHelper.getJournalArticleFieldValue(emergencyNumber, WSConstants.JSON_WC_TITLE, Locale.FRANCE));
            emergencyNumberJson.put(WSConstants.JSON_WC_TITLE, titleJSON);

            emergencyNumberJson.put(WSConstants.JSON_WC_ORDER, JournalArticleHelper.getJournalArticleFieldValue(emergencyNumber,"order",Locale.FRANCE));
            emergencyNumberJson.put(WSConstants.JSON_WC_NUMBER, JournalArticleHelper.getJournalArticleFieldValue(emergencyNumber,"number",Locale.FRANCE));
            JSONObject colorJSON = JSONFactoryUtil.createJSONObject();
            colorJSON.put(WSConstants.JSON_WC_FONT_COLOR, JournalArticleHelper.getJournalArticleFieldValue(emergencyNumber,"fontColor",Locale.FRANCE));
            colorJSON.put(WSConstants.JSON_WC_BACKGROUND_COLOR, JournalArticleHelper.getJournalArticleFieldValue(emergencyNumber,"backgroundColor",Locale.FRANCE));
            emergencyNumberJson.put(WSConstants.JSON_WC_COLOR, colorJSON);
            emergencyNumbersJSON.put(emergencyNumberJson);
        }
        for(Map.Entry emergencyHelpEntry : emergencyHelpsMap.entrySet()){
            JSONObject emergencyHelpJSON = JSONFactoryUtil.createJSONObject();
            // Recuperation des valeurs du MapEntry
            AssetCategory category = (AssetCategory) emergencyHelpEntry.getKey();
            List<JournalArticle> emergencyHelps = (List<JournalArticle>) emergencyHelpEntry.getValue();

            emergencyHelpJSON.put(WSConstants.JSON_WC_CATEGORY_ID, category.getCategoryId());
            int order = 1;
            try {
                AssetCategoryProperty assetCategoryProperty = AssetCategoryPropertyLocalServiceUtil.getCategoryProperty(category.getCategoryId(), "order");
                if(Validator.isNotNull(assetCategoryProperty) && Validator.isNotNull(assetCategoryProperty.getValue()))
                    order = Integer.parseInt(assetCategoryProperty.getValue());
            } catch (PortalException | NumberFormatException e) {
            }
            emergencyHelpJSON.put(WSConstants.JSON_WC_CATEGORY_ORDER, order);
            // CategoryTitle en fonction des differentes langues
            JSONObject categoryTitleJSON = JSONFactoryUtil.createJSONObject();
            categoryTitleJSON.put("fr_FR", category.getTitle(Locale.FRANCE));
            emergencyHelpJSON.put(WSConstants.JSON_WC_CATEGORY_TITLE, categoryTitleJSON);
            JSONArray categoryContentsJSON = JSONFactoryUtil.createJSONArray();
            for(JournalArticle emergencyHelp : emergencyHelps ) {
                JSONObject categoryContentJSON = JSONFactoryUtil.createJSONObject();
                JSONObject titleJSON = JSONFactoryUtil.createJSONObject();
                titleJSON.put("fr_FR", JournalArticleHelper.getJournalArticleFieldValue(emergencyHelp, WSConstants.JSON_WC_TITLE, Locale.FRANCE));
                categoryContentJSON.put(WSConstants.JSON_WC_TITLE, titleJSON);
                categoryContentJSON.put(WSConstants.JSON_WC_NUMBER, JournalArticleHelper.getJournalArticleFieldValue(emergencyHelp, "number", Locale.FRANCE));
                categoryContentJSON.put(WSConstants.JSON_WC_ORDER, JournalArticleHelper.getJournalArticleFieldValue(emergencyHelp, "order", Locale.FRANCE));
                categoryContentsJSON.put(categoryContentJSON);
            }
            emergencyHelpJSON.put(WSConstants.JSON_WC_CATEGORY_CONTENT, categoryContentsJSON);
            emergencyHelpsJSON.put(emergencyHelpJSON);
        }
        jsonEmergency.put(WSConstants.JSON_WC_EMERGENCY_NUMBERS, emergencyNumbersJSON);
        jsonEmergency.put(WSConstants.JSON_WC_EMERGENCY_HELPS, emergencyHelpsJSON);
        return jsonEmergency;
    }


    public static JSONObject getSocialNetworkCSMapJSON(JournalArticle socialNetwork) {
        JSONObject jsonJournalArticle = JSONFactoryUtil.createJSONObject();
        if (socialNetwork != null) {
            // Various-Data
            jsonJournalArticle.put(WSConstants.JSON_WC_ID, socialNetwork.getResourcePrimKey());

            JSONObject titles = JSONFactoryUtil.createJSONObject();
            String titleFR = JournalArticleHelper.getJournalArticleFieldValue(socialNetwork, "title", Locale.FRANCE);
            titles.put(WSConstants.JSON_LANGUAGE_FRANCE, titleFR);
            jsonJournalArticle.put(WSConstants.JSON_WC_TITLE, titles);

            jsonJournalArticle.put(WSConstants.JSON_WC_ORDER, JournalArticleHelper.getJournalArticleFieldValue(socialNetwork, "order", Locale.FRANCE));

            jsonJournalArticle.put(WSConstants.JSON_WC_URL, JournalArticleHelper.getJournalArticleFieldValue(socialNetwork, "url", Locale.FRANCE));

            String picto = JournalArticleHelper.getJournalArticleFieldValue(socialNetwork, "picto", Locale.FRANCE);
            if(Validator.isNotNull(picto)) {
                String pictoURL = AssetPublisherTemplateHelper.getDocumentUrl(picto);
                jsonJournalArticle.put(WSConstants.JSON_WC_PICTO, StrasbourgPropsUtil.getBaseURL() + pictoURL);
            }

            jsonJournalArticle.put(WSConstants.JSON_WC_COLOR, JournalArticleHelper.getJournalArticleFieldValue(socialNetwork, "socialNetworkColor", Locale.FRANCE));
        }
        return  jsonJournalArticle;
    }

    public static JSONObject simpleContentCSMapJSON(List<JournalArticle> generalConditions) throws PortalException {
        JSONObject json = JSONFactoryUtil.createJSONObject();
        for (JournalArticle generalCondition : generalConditions) {
            // CategoryTitle en fonction des differentes langues
            JSONObject titleJSON = JSONFactoryUtil.createJSONObject();
            titleJSON.put("fr_FR", JournalArticleHelper.getJournalArticleFieldValue(generalCondition, WSConstants.JSON_WC_CONTENT, Locale.FRANCE));
            json.put(WSConstants.JSON_WC_TEXT, titleJSON);
        }
        return json;
    }

    public static JSONArray SimplePOIsCSMapJSON(List<JournalArticle> SimplePOIs, Date lastUpdateTime, boolean maj) throws PortalException {
        JSONArray SimplePOIsJSON = JSONFactoryUtil.createJSONArray();
        for(JournalArticle SimplePOI : SimplePOIs){
            JSONObject SimplePOIJSON = JSONFactoryUtil.createJSONObject();
            SimplePOIJSON.put("id", SimplePOI.getResourcePrimKey());
            // CategoryTitle en fonction des differentes langues
            JSONObject nameJSON = JSONFactoryUtil.createJSONObject();
            nameJSON.put("fr_FR", JournalArticleHelper.getJournalArticleFieldValue(SimplePOI, "name", Locale.FRANCE));
            SimplePOIJSON.put(WSConstants.JSON_PLACE_NAME, nameJSON);
            String picto = JournalArticleHelper.getJournalArticleFieldValue(SimplePOI, "picto", Locale.FRANCE);
            if(Validator.isNotNull(picto)) {
                String pictoURL = AssetPublisherTemplateHelper.getDocumentUrl(picto);
                JSONObject jsonPicto = JSONFactoryUtil.createJSONObject();
                jsonPicto.put(WSConstants.JSON_PICTO_URL, StrasbourgPropsUtil.getBaseURL() + pictoURL);
                if(maj){
                    jsonPicto.put(WSConstants.JSON_MAJ, maj);
                } else {
                    List<String> pictoContents = Arrays.asList(picto.split(","));
                    String dlFileEntryId = "";
                    for(String pictoContent : pictoContents){
                        if(pictoContent.contains("fileEntryId")){
                            dlFileEntryId = pictoContent.split(":")[1].replace("\"","");
                        }
                    }
                    DLFileEntry pictoFile = DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(dlFileEntryId));
                    maj = lastUpdateTime.before(pictoFile.getModifiedDate());
                    jsonPicto.put(WSConstants.JSON_MAJ, maj);
                }
                SimplePOIJSON.put(WSConstants.JSON_PICTO, jsonPicto);
            }
            SimplePOIJSON.put(WSConstants.JSON_PLACE_OPDENDATA_URL, JournalArticleHelper.getJournalArticleFieldValue(SimplePOI,"openDataURL",Locale.FRANCE));
            AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(JournalArticle.class.getName(), SimplePOI.getResourcePrimKey());
            JSONArray SimplePOICategoriesJSON = JSONFactoryUtil.createJSONArray();
            for(AssetCategory category : assetEntry.getCategories()){
                try {
                    String idCategory = AssetCategoryPropertyLocalServiceUtil.getCategoryProperty(category.getCategoryId(), "SIG").getValue();
                    SimplePOICategoriesJSON.put(idCategory);
                } catch(PortalException e){/* Using the default value */}
            }
            SimplePOIJSON.put(WSConstants.JSON_PLACE_TYPES, SimplePOICategoriesJSON);

            SimplePOIsJSON.put(SimplePOIJSON);
        }
        return SimplePOIsJSON;
    }

    static public JSONObject favoritesCSMapJSON(Favorite favorite) {
        JSONObject jsonFavorite = JSONFactoryUtil.createJSONObject();
        jsonFavorite.put("favoriteId", favorite.getFavoriteId());
        jsonFavorite.put("title", favorite.getTitle());
        jsonFavorite.put("type", favorite.getTypeId());
        jsonFavorite.put("order", favorite.getOrder());
        if(favorite.getTypeId()== FavoriteType.PLACE.getId()) {
            jsonFavorite.put("elementId", PlaceLocalServiceUtil.fetchPlace(favorite.getEntityId()).getSIGid());
        } else if(favorite.getTypeId()== FavoriteType.EVENT.getId()) {
            jsonFavorite.put("elementId", EventLocalServiceUtil.fetchEvent(favorite.getEntityId()).getEventId());
        } else if(favorite.getTypeId()== FavoriteType.ARRET.getId()) {
            jsonFavorite.put("elementId", ArretLocalServiceUtil.fetchArret(favorite.getEntityId()).getStopId());
        }
        jsonFavorite.put("content", favorite.getContent());
        return jsonFavorite;
    }

    static public JSONObject arretCSMapJSON(Arret arret) {
        JSONObject json = JSONFactoryUtil.createJSONObject();
        json.put("stopId", arret.getStopId());
        json.put("stopCode", arret.getCode());
        json.put("title", arret.getTitle());
        json.put("type", arret.getType());
        json.put("mercatorX", arret.getLongitude());
        json.put("mercatorY", arret.getLatitude());
        String stopId = arret.getStopId();
        List<Direction> directions = DirectionLocalServiceUtil.getByStopId(stopId);
        JSONArray linesJSON = JSONFactoryUtil.createJSONArray();
        List<String> lineNumbers = new ArrayList<>();
        for(Direction direction : directions){
            String lineName = LigneLocalServiceUtil.getByRouteId(direction.getRouteId()).getShortName();
            if(!lineNumbers.contains(lineName)) {
                lineNumbers.add(lineName);
                linesJSON.put(lineName);
            }
        }
        json.put("lines", linesJSON);
        return json;
    }

    static public JSONObject lineCSMapJSON(Ligne line) {
        JSONObject json = JSONFactoryUtil.createJSONObject();
        json.put("lineNumber", line.getShortName());
        json.put("type", line.getType());
        json.put("backgroundColor", line.getBackgroundColor());
        json.put("textColor", line.getTextColor());
        return json;
    }

    static public JSONObject serviceCSMapJSON(ServiceNotif service) {
        JSONObject json = JSONFactoryUtil.createJSONObject();
        json.put("topic",service.getCsmapTopic());
        String name = "";
        String label = service.getCsmapSubscriptionLabel();
        if(Validator.isNotNull(label) ||label!=""){
            name = label;
        } else {
            name = service.getName();
        }
        json.put("name",name);
        json.put("mandatory",service.getCsmapSubscriptionMandatory());
        return json;
    }

}
