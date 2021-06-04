package eu.strasbourg.portlet.dynamic_search_asset;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.portlet.dynamic_search_asset.constants.Constants;
import eu.strasbourg.service.activity.model.Activity;
import eu.strasbourg.service.activity.model.ActivityCourse;
import eu.strasbourg.service.agenda.model.Event;
import eu.strasbourg.service.agenda.model.Manifestation;
import eu.strasbourg.service.edition.model.Edition;
import eu.strasbourg.service.edition.model.EditionGallery;
import eu.strasbourg.service.official.model.Official;
import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.service.project.model.BudgetParticipatif;
import eu.strasbourg.service.project.model.Initiative;
import eu.strasbourg.service.project.model.Participation;
import eu.strasbourg.service.project.model.Petition;
import eu.strasbourg.service.project.model.Project;
import eu.strasbourg.service.video.model.Video;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.JSONHelper;
import eu.strasbourg.utils.JournalArticleHelper;
import eu.strasbourg.utils.LayoutHelper;
import eu.strasbourg.utils.StrasbourgPropsUtil;
import eu.strasbourg.utils.constants.VocabularyNames;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class JSONSearchHelper {

    /**
     * création de JSON pour Événement
     */
	public static JSONObject createEventSearchJson(Event event, Locale locale, ThemeDisplay themeDisplay, String publikUserId, String configAffichage){
	    JSONObject jsonEvent = JSONFactoryUtil.createJSONObject();
        jsonEvent.put(
                Constants.ATTRIBUTE_CLASSNAME,
                Event.class.getName()
        );

        jsonEvent.put(
                Constants.ATTRIBUTE_TITLE,
                event.getTitle(locale)
        );

	    switch (configAffichage){
            case Constants.SEARCH_FORM_PLACIT :
                jsonEvent.put(
                        Constants.ATTRIBUTE_LINK,
                        Utils.getHomeURL(themeDisplay) + Constants.DETAIL_EVENT_URL + event.getEventId()
                );

                jsonEvent.put(
                        Constants.ATTRIBUTE_IS_USER_PARTICIPATE,
                        !publikUserId.equals("") && event.isUserParticipates(publikUserId)
                );

                jsonEvent.put(
                        Constants.ATTRIBUTE_FIRST_DATE,
                        event.getCurrentOrFuturePeriodStringDate()
                );

                jsonEvent.put(
                        Constants.ATTRIBUTE_COMPLETE_ADDRESS,
                        event.getCompleteAddress(Locale.FRENCH)
                );

                jsonEvent.put(
                        Constants.ATTRIBUTE_NB_PART,
                        event.getNbEventParticipations()
                );
                break;
            case Constants.SEARCH_FORM_STRASBOURG :
                JSONObject types = JSONFactoryUtil.createJSONObject();
                types.put(locale.toString(), event.getTypeLabel(locale));
                jsonEvent.put(
                        Constants.ATTRIBUTE_CATEGORIES,
                        types
                );

                jsonEvent.put(
                        Constants.ATTRIBUTE_LINK_ABSOLUTE,
                        themeDisplay.getPortalURL() + Utils.getHomeURL(themeDisplay) + Constants.DETAIL_EVENT_STRAS_URL + event.getEventId()
                );

                jsonEvent.put(
                        Constants.ATTRIBUTE_SCHEDULE,
                        event.getEventScheduleDisplay(locale)
                );

                jsonEvent.put(
                        Constants.ATTRIBUTE_ID,
                        event.getEventId()
                );

                jsonEvent.put(
                        Constants.ATTRIBUTE_DESCRIPTION,
                        event.getDescription(locale)
                );

                jsonEvent.put(
                        Constants.ATTRIBUTE_LINK_STRAS,
                        Utils.getHomeURL(themeDisplay) + Constants.DETAIL_EVENT_STRAS_URL + event.getEventId()
                );
                break;
        }

        return jsonEvent;
    }

    /**
     * création de JSON pour Projet
     */
    public static JSONObject createProjectSearchJson(Project project, ThemeDisplay themeDisplay, String configAffichage){
        JSONObject jsonProject = JSONFactoryUtil.createJSONObject();

        jsonProject.put(
                Constants.ATTRIBUTE_CLASSNAME,
                Project.class.getName()
        );

        jsonProject.put(
                Constants.ATTRIBUTE_LINK,
                Utils.getHomeURL(themeDisplay) + project.getDetailURL()
        );

        switch (configAffichage) {
            case Constants.SEARCH_FORM_PLACIT:
                jsonProject.put(
                        Constants.ATTRIBUTE_TITLE,
                        HtmlUtil.stripHtml(HtmlUtil.escape(project.getTitle()))
                );

                jsonProject.put(
                        Constants.ATTRIBUTE_DESCRIPTION,
                        HtmlUtil.stripHtml(HtmlUtil.escape(project.getDescription()))
                );

                jsonProject.put(
                        Constants.ATTRIBUTE_IMAGE_URL,
                        project.getImageURL()
                );
                break;
            case Constants.SEARCH_FORM_STRASBOURG:
                break;
        }

        return jsonProject;
    }

    /**
     * création de JSON pour Participation
     */
    public static JSONObject createParticipationSearchJson(Participation participation, Locale locale, ThemeDisplay themeDisplay, String configAffichage) throws PortalException {
        JSONObject jsonParticipation = JSONFactoryUtil.createJSONObject();

        jsonParticipation.put(
                Constants.ATTRIBUTE_CLASSNAME,
                Participation.class.getName()
        );

        jsonParticipation.put(
                Constants.ATTRIBUTE_LINK,
                Utils.getHomeURL(themeDisplay) + Constants.DETAIL_PARTICIPATION_URL + participation.getParticipationId()
        );

        switch (configAffichage) {
            case Constants.SEARCH_FORM_PLACIT:
                jsonParticipation.put(
                        Constants.ATTRIBUTE_TITLE,
                        HtmlUtil.stripHtml(HtmlUtil.escape(participation.getTitle()))
                );

                jsonParticipation.put(
                        Constants.ATTRIBUTE_NB_LIKES,
                        participation.getNbLikes()
                );

                jsonParticipation.put(
                        Constants.ATTRIBUTE_NB_DISLIKES,
                        participation.getNbDislikes()
                );

                jsonParticipation.put(
                        Constants.ATTRIBUTE_STATUT_CODE,
                        participation.getParticipationStatus()
                );

                jsonParticipation.put(
                        Constants.ATTRIBUTE_TYPE_COLOR,
                        participation.getTypeCategoryColor()
                );

                jsonParticipation.put(
                        Constants.ATTRIBUTE_AUTHOR_IMAGE_URL,
                        participation.getImageAuthorURL(themeDisplay)
                );

                jsonParticipation.put(
                        Constants.ATTRIBUTE_AUTHOR,
                        HtmlUtil.stripHtml(HtmlUtil.escape(participation.getAuthorFullName()))
                );

                AssetCategory typeCategory = participation.getTypeCategory();
                if(Validator.isNotNull(typeCategory))
                    jsonParticipation.put(
                            Constants.ATTRIBUTE_TYPE_LABEL,
                            typeCategory.getTitle(locale)
                    );

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                jsonParticipation.put(
                        Constants.ATTRIBUTE_CREATE_DATE,
                        dateFormat.format(participation.getCreateDate())
                );

                jsonParticipation.put(
                        Constants.ATTRIBUTE_STATUS_DETAIL_LABEL,
                        participation.getStatusDetailLabel()
                );
                break;
            case Constants.SEARCH_FORM_STRASBOURG:
                break;
        }

        return jsonParticipation;
    }

    /**
     * création de JSON pour Vidéo
     */
    public static JSONObject createVideoSearchJson(Video video, Locale locale, ThemeDisplay themeDisplay, String configAffichage){
        JSONObject jsonVideo = JSONFactoryUtil.createJSONObject();

        jsonVideo.put(
                Constants.ATTRIBUTE_CLASSNAME,
                Video.class.getName()
        );

        jsonVideo.put(
                Constants.ATTRIBUTE_LINK,
                Utils.getHomeURL(themeDisplay) + Constants.DETAIL_VIDEO_URL + video.getVideoId()
        );

        switch (configAffichage) {
            case Constants.SEARCH_FORM_PLACIT:
                jsonVideo.put(
                        Constants.ATTRIBUTE_TITLE,
                        video.getTitle(locale)
                );

                jsonVideo.put(
                        Constants.ATTRIBUTE_IMAGE_URL,
                        video.getImageURL()
                );

                jsonVideo.put(
                        Constants.ATTRIBUTE_NB_LIKES,
                        video.getNbLikes()
                );

                jsonVideo.put(
                        Constants.ATTRIBUTE_NB_DISLIKES,
                        video.getNbDislikes()
                );

                String videoURL = video.getSource(locale);
                String site = video.getSiteVideo(videoURL);
                String videoId = video.getVideoId(site, videoURL);
                jsonVideo.put(
                        Constants.ATTRIBUTE_NB_VIEWS,
                        video.getNbViews(site,videoId)
                );
                break;
            case Constants.SEARCH_FORM_STRASBOURG:
                break;
        }

        return jsonVideo;
    }

    /**
     * création de JSON pour Pétition
     */
    public static JSONObject createPetitionSearchJson(Petition petition, ThemeDisplay themeDisplay, String configAffichage){
        JSONObject jsonPetition = JSONFactoryUtil.createJSONObject();

        jsonPetition.put(
                Constants.ATTRIBUTE_CLASSNAME,
                Petition.class.getName()
        );

        jsonPetition.put(
                Constants.ATTRIBUTE_LINK,
                Utils.getHomeURL(themeDisplay) + Constants.DETAIL_PETITION_URL + petition.getPetitionId()
        );

        switch (configAffichage) {
            case Constants.SEARCH_FORM_PLACIT:
                jsonPetition.put(
                        Constants.ATTRIBUTE_TITLE,
                        HtmlUtil.stripHtml(HtmlUtil.escape(petition.getTitle()))
                );

                jsonPetition.put(
                        Constants.ATTRIBUTE_IMAGE_URL,
                        petition.getImageURL()
                );

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                jsonPetition.put(
                        Constants.ATTRIBUTE_CREATE_DATE,
                        dateFormat.format(petition.getCreateDate())
                );

                jsonPetition.put(
                        Constants.ATTRIBUTE_USER_NAME,
                        HtmlUtil.stripHtml(HtmlUtil.escape(petition.getUserName()))
                );

                jsonPetition.put(
                        Constants.ATTRIBUTE_PRO_DUREE_FR,
                        petition.getProDureeFR()
                );

                jsonPetition.put(
                        Constants.ATTRIBUTE_POURCENTAGE_SIGNATURE,
                        petition.getPourcentageSignature()
                );

                jsonPetition.put(
                        Constants.ATTRIBUTE_NOMBRE_SIGNATURE,
                        petition.getNombreSignature()
                );

                jsonPetition.put(
                        Constants.ATTRIBUTE_QUOTA_SIGNATURE,
                        petition.getQuotaSignature()
                );
                break;
            case Constants.SEARCH_FORM_STRASBOURG:
                break;
        }

        return jsonPetition;
    }

    /**
     * création de JSON pour Budget Participatif
     */
    public static JSONObject createBudgetParticipatifSearchJson(BudgetParticipatif bp, Locale locale, ThemeDisplay themeDisplay, String configAffichage){
        JSONObject jsonBP = JSONFactoryUtil.createJSONObject();

        jsonBP.put(
                Constants.ATTRIBUTE_CLASSNAME,
                BudgetParticipatif.class.getName()
        );

        jsonBP.put(
                Constants.ATTRIBUTE_LINK,
                Utils.getHomeURL(themeDisplay) + Constants.DETAIL_BUDGET_PARTICIPATIF_URL + bp.getBudgetParticipatifId()
        );

        switch (configAffichage) {
            case Constants.SEARCH_FORM_PLACIT:
                jsonBP.put(
                        Constants.ATTRIBUTE_TITLE,
                        HtmlUtil.stripHtml(HtmlUtil.escape(bp.getTitle()))
                );

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                jsonBP.put(
                        Constants.ATTRIBUTE_CREATE_DATE,
                        dateFormat.format(bp.getCreateDate())
                );

                jsonBP.put(
                        Constants.ATTRIBUTE_AUTHOR,
                        HtmlUtil.stripHtml(HtmlUtil.escape(bp.getAuthor()))
                );

                jsonBP.put(
                        Constants.ATTRIBUTE_AUTHOR_IMAGE_URL,
                        bp.getAuthorImageURL()
                );

                jsonBP.put(
                        Constants.ATTRIBUTE_BP_STATUT,
                        HtmlUtil.stripHtml(HtmlUtil.escape(bp.getBudgetParticipatifStatusTitle(locale)))
                );

                jsonBP.put(
                        Constants.ATTRIBUTE_NB_SUPPORTS,
                        bp.getNbSupports()
                );
                break;
            case Constants.SEARCH_FORM_STRASBOURG:
                break;
        }

        return jsonBP;
    }

    /**
     * création de JSON pour Initiative
     */
    public static JSONObject createInitiativeSearchJson(Initiative initiative, ThemeDisplay themeDisplay, String configAffichage){
        JSONObject jsonInitiative = JSONFactoryUtil.createJSONObject();

        jsonInitiative.put(
                Constants.ATTRIBUTE_CLASSNAME,
                Initiative.class.getName()
        );

        jsonInitiative.put(
                Constants.ATTRIBUTE_LINK,
                Utils.getHomeURL(themeDisplay) + Constants.DETAIL_INITIATIVE_URL + initiative.getInitiativeId()
        );

        switch (configAffichage) {
            case Constants.SEARCH_FORM_PLACIT:

                jsonInitiative.put(
                        Constants.ATTRIBUTE_TITLE,
                        HtmlUtil.stripHtml(HtmlUtil.escape(initiative.getTitle()))
                );

                jsonInitiative.put(
                        Constants.ATTRIBUTE_IMAGE_URL,
                        initiative.getImageURL()
                );

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                jsonInitiative.put(
                        Constants.ATTRIBUTE_CREATE_DATE,
                        dateFormat.format(initiative.getCreateDate())
                );

                jsonInitiative.put(
                        Constants.ATTRIBUTE_AUTHOR,
                        HtmlUtil.stripHtml(HtmlUtil.escape(initiative.getAuthorLabel()))
                );

                jsonInitiative.put(
                        Constants.ATTRIBUTE_AUTHOR_IMAGE_URL,
                        initiative.getAuthorImageURL()
                );

                jsonInitiative.put(
                        Constants.ATTRIBUTE_NB_HELPS,
                        initiative.getNbHelps()
                );
                break;
            case Constants.SEARCH_FORM_STRASBOURG:
                break;
        }

        return jsonInitiative;
    }

    /**
     * création de JSON pour JournalArticle avant identification d'un potentiel Article
     */
    public static JSONObject createJournalArticleSearchJson(AssetEntry assetEntry, Locale locale, ThemeDisplay themeDisplay, String configAffichage) throws PortalException {
        JSONObject jsonArticle = JSONFactoryUtil.createJSONObject();

        JournalArticle journalArticle = JournalArticleServiceUtil.getLatestArticle(assetEntry.getClassPK());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");

        jsonArticle.put(
                Constants.ATTRIBUTE_CLASSNAME,
                JournalArticle.class.getName()
        );

        String detailURL = LayoutHelper.getJournalArticleLayoutURL(journalArticle.getGroupId(), journalArticle.getArticleId(), themeDisplay);
        jsonArticle.put(
                Constants.ATTRIBUTE_LINK,
                detailURL
        );

        String title = JournalArticleHelper.getJournalArticleFieldValue(journalArticle, "title", locale);
        if(Validator.isNotNull(title)) {
            jsonArticle.put(
                    Constants.ATTRIBUTE_TITLE,
                    title
            );
        }else {
            jsonArticle.put(
                    Constants.ATTRIBUTE_TITLE,
                    journalArticle.getTitle(locale)
            );
        }

        jsonArticle.put(
                Constants.ATTRIBUTE_CHAPO,
                JournalArticleHelper.getJournalArticleFieldValue(journalArticle, "chapo", locale)
        );

        switch (configAffichage) {
            case Constants.SEARCH_FORM_PLACIT:
                jsonArticle.put(
                        Constants.ATTRIBUTE_IMAGE_URL,
                        JournalArticleHelper.getJournalArticleFieldValue(journalArticle, "thumbnail", locale)
                );
                break;
            case Constants.SEARCH_FORM_STRASBOURG:
                JSONObject types = JSONFactoryUtil.createJSONObject();
                List<AssetCategory> newsType = AssetVocabularyHelper.getAssetEntryCategoriesByVocabulary(assetEntry, VocabularyNames.NEWS_TYPE);
                StringBuilder newsTypeLabel = new StringBuilder();
                for (AssetCategory type : newsType) {
                    if (types.length() > 0) {
                        newsTypeLabel.append(" - ");
                    }
                    newsTypeLabel.append(type.getTitle(locale));
                }
                types.put(locale.toString(), newsTypeLabel.toString());
                jsonArticle.put(
                        Constants.ATTRIBUTE_CATEGORIES,
                        types
                );

                jsonArticle.put(
                        Constants.ATTRIBUTE_ID,
                        journalArticle.getArticleId()
                );

                jsonArticle.put(
                        Constants.ATTRIBUTE_MODIFIED_DATE,
                        dateFormat.format(journalArticle.getModifiedDate())
                );

                jsonArticle.put(
                        Constants.ATTRIBUTE_TYPE,
                        detailURL.contains("/-/")?6:7
                );

                jsonArticle.put(
                        Constants.ATTRIBUTE_GROUP_ID,
                        themeDisplay.getScopeGroupId()
                );
                break;
        }
        
        return jsonArticle;
    }

    /**
     * création de JSON pour Official
     */
    public static JSONObject createOfficialSearchJson(Official official, Locale locale, ThemeDisplay themeDisplay, String configAffichage){
        JSONObject jsonOfficial = JSONFactoryUtil.createJSONObject();

        jsonOfficial.put(
                Constants.ATTRIBUTE_CLASSNAME,
                Official.class.getName()
        );

        jsonOfficial.put(
                Constants.ATTRIBUTE_LINK,
                Utils.getHomeURL(themeDisplay) + Constants.DETAIL_OFFICIAL_URL + official.getOfficialId()
        );

        switch (configAffichage){
            case Constants.SEARCH_FORM_PLACIT :
                break;
            case Constants.SEARCH_FORM_STRASBOURG :
                jsonOfficial.put(
                        Constants.ATTRIBUTE_CATEGORIES,
                        JSONHelper.getJSONFromI18nMap(official.getTown().getTitleMap())
                );

                jsonOfficial.put(
                        Constants.ATTRIBUTE_FIRST_NAME,
                        official.getFirstName()
                );

                jsonOfficial.put(
                        Constants.ATTRIBUTE_LAST_NAME,
                        official.getLastName()
                );

                if(Validator.isNotNull(official.getFonctionEurometropole()))
                    jsonOfficial.put(
                            Constants.ATTRIBUTE_FONTION_EURO,
                            official.getFonctionEurometropole().getTitle(locale)
                    );

                if(Validator.isNotNull(official.getFonctionCity()))
                    jsonOfficial.put(
                            Constants.ATTRIBUTE_FONCTION_CITY,
                            official.getFonctionCity().getTitle(locale)
                    );
                break;
        }

        jsonOfficial.put(
                Constants.ATTRIBUTE_LINK_ABSOLUTE,
                themeDisplay.getPortalURL() + Utils.getHomeURL(themeDisplay) + Constants.DETAIL_OFFICIAL_URL + official.getOfficialId()
        );

        jsonOfficial.put(
                Constants.ATTRIBUTE_TITLE,
                official.getFirstName() + " " + official.getLastName()
        );

        return jsonOfficial;
    }

    /**
     * création de JSON pour Edition
     */
    public static JSONObject createEditionSearchJson(Edition edition, Locale locale, ThemeDisplay themeDisplay, String configAffichage){
        JSONObject jsonEdition = JSONFactoryUtil.createJSONObject();

        jsonEdition.put(
                Constants.ATTRIBUTE_CLASSNAME,
                Edition.class.getName()
        );

        jsonEdition.put(
                Constants.ATTRIBUTE_LINK,
                Utils.getHomeURL(themeDisplay) + Constants.DETAIL_EDITION_URL + edition.getEditionId()
        );

        switch (configAffichage){
            case Constants.SEARCH_FORM_PLACIT :
                break;
            case Constants.SEARCH_FORM_STRASBOURG :
                jsonEdition.put(
                        Constants.ATTRIBUTE_CATEGORIES,
                        edition.getTypesLabels(locale)
                );

                jsonEdition.put(
                        Constants.ATTRIBUTE_LINK_ABSOLUTE,
                        themeDisplay.getPortalURL() + Utils.getHomeURL(themeDisplay) + Constants.DETAIL_EDITION_URL + edition.getEditionId()
                );

                jsonEdition.put(
                        Constants.ATTRIBUTE_TITLE,
                        edition.getTitle(locale)
                );

                jsonEdition.put(
                        Constants.ATTRIBUTE_SCHEDULE,
                        edition.getDiffusionDateMonth() +
                                (Validator.isNotNull(edition.getDiffusionDateMonth())?"/":"") +
                                edition.getDiffusionDateYear()
                );

                jsonEdition.put(
                        Constants.ATTRIBUTE_ID,
                        edition.getEditionId()
                );

                jsonEdition.put(
                        Constants.ATTRIBUTE_DESCRIPTION,
                        edition.getDescription(locale)
                );
                break;
        }

        return jsonEdition;
    }

    /**
     * création de JSON pour Manifestation
     */
    public static JSONObject createManifestationSearchJson(Manifestation manifestation, Locale locale, ThemeDisplay themeDisplay, String configAffichage){
        JSONObject jsonManifestation = JSONFactoryUtil.createJSONObject();

        jsonManifestation.put(
                Constants.ATTRIBUTE_CLASSNAME,
                Manifestation.class.getName()
        );

        jsonManifestation.put(
                Constants.ATTRIBUTE_LINK,
                Utils.getHomeURL(themeDisplay) + Constants.DETAIL_MANIF_URL + manifestation.getManifestationId()
        );

        switch (configAffichage) {
            case Constants.SEARCH_FORM_PLACIT:
                break;
            case Constants.SEARCH_FORM_STRASBOURG:
                jsonManifestation.put(
                        Constants.ATTRIBUTE_CATEGORIES,
                        manifestation.getTypeLabel(locale)
                );

                jsonManifestation.put(
                        Constants.ATTRIBUTE_LINK_ABSOLUTE,
                        themeDisplay.getPortalURL() + Utils.getHomeURL(themeDisplay) + Constants.DETAIL_MANIF_URL + manifestation.getManifestationId()
                );

                jsonManifestation.put(
                        Constants.ATTRIBUTE_TITLE,
                        manifestation.getTitle(locale)
                );

                jsonManifestation.put(
                        Constants.ATTRIBUTE_SCHEDULE,
                        manifestation.getManifestationScheduleDisplay(locale)
                );

                jsonManifestation.put(
                        Constants.ATTRIBUTE_ID,
                        manifestation.getManifestationId()
                );

                jsonManifestation.put(
                        Constants.ATTRIBUTE_DESCRIPTION,
                        manifestation.getDescription(locale)
                );
                break;
        }

        return jsonManifestation;
    }

    /**
     * création de JSON pour EditionGallery
     */
    public static JSONObject createEditionGallerySearchJson(EditionGallery editionGallery, Locale locale, ThemeDisplay themeDisplay, String configAffichage){
        JSONObject jsonEditionGallery = JSONFactoryUtil.createJSONObject();

        jsonEditionGallery.put(
                Constants.ATTRIBUTE_CLASSNAME,
                EditionGallery.class.getName()
        );

        jsonEditionGallery.put(
                Constants.ATTRIBUTE_LINK,
                Utils.getHomeURL(themeDisplay) + Constants.DETAIL_GALERIE_URL + editionGallery.getGalleryId()
        );

        switch (configAffichage) {
            case Constants.SEARCH_FORM_PLACIT:
                break;
            case Constants.SEARCH_FORM_STRASBOURG:
                jsonEditionGallery.put(
                        Constants.ATTRIBUTE_CATEGORIES,
                        editionGallery.getTypesLabels(locale)
                );

                jsonEditionGallery.put(
                        Constants.ATTRIBUTE_LINK_ABSOLUTE,
                        themeDisplay.getPortalURL() + Utils.getHomeURL(themeDisplay) + Constants.DETAIL_GALERIE_URL + editionGallery.getGalleryId()
                );

                jsonEditionGallery.put(
                        Constants.ATTRIBUTE_TITLE,
                        editionGallery.getTitle(locale)
                );

                jsonEditionGallery.put(
                        Constants.ATTRIBUTE_ID,
                        editionGallery.getGalleryId()
                );

                jsonEditionGallery.put(
                        Constants.ATTRIBUTE_DESCRIPTION,
                        editionGallery.getDescription(locale)
                );
                break;
        }

        return jsonEditionGallery;
    }

    /**
     * création de JSON pour Place
     */
    public static JSONObject createPlaceSearchJson(Place place, Locale locale, ThemeDisplay themeDisplay, String configAffichage){
        JSONObject jsonPlace = JSONFactoryUtil.createJSONObject();

        jsonPlace.put(
                Constants.ATTRIBUTE_CLASSNAME,
                Place.class.getName()
        );

        jsonPlace.put(
                Constants.ATTRIBUTE_LINK,
                Utils.getHomeURL(themeDisplay) + Constants.DETAIL_PLACE_URL + place.getSIGid()
        );

        switch (configAffichage) {
            case Constants.SEARCH_FORM_PLACIT:
                break;
            case Constants.SEARCH_FORM_STRASBOURG:
                jsonPlace.put(
                        Constants.ATTRIBUTE_CATEGORIES,
                        place.getTypeLabel(locale)
                );

                jsonPlace.put(
                        Constants.ATTRIBUTE_LINK_ABSOLUTE,
                        themeDisplay.getPortalURL() + Utils.getHomeURL(themeDisplay) + Constants.DETAIL_PLACE_URL + place.getSIGid()
                );

                jsonPlace.put(
                        Constants.ATTRIBUTE_ID,
                        place.getPlaceId()
                );

                if(Validator.isNotNull(place.getCityCategory()))
                    jsonPlace.put(
                            Constants.ATTRIBUTE_CITY,
                            JSONHelper.getJSONFromI18nMap(place.getCityCategory().getTitleMap())
                    );

                jsonPlace.put(
                        Constants.ATTRIBUTE_TITLE,
                        place.getAlias(locale)
                );
                break;
        }

        return jsonPlace;
    }

    /**
     * création de JSON pour ActivityCourse
     */
    public static JSONObject createActivityCourseSearchJson(ActivityCourse activityCourse, Locale locale, ThemeDisplay themeDisplay, String configAffichage){
        JSONObject jsonActivityCourse = JSONFactoryUtil.createJSONObject();

        jsonActivityCourse.put(
                Constants.ATTRIBUTE_CLASSNAME,
                ActivityCourse.class.getName()
        );

        jsonActivityCourse.put(
                Constants.ATTRIBUTE_LINK,
                Utils.getHomeURL(themeDisplay) + Constants.DETAIL_COURSE_URL + activityCourse.getActivityCourseId()
        );

        switch (configAffichage) {
            case Constants.SEARCH_FORM_PLACIT:
                break;
            case Constants.SEARCH_FORM_STRASBOURG:
                jsonActivityCourse.put(
                        Constants.ATTRIBUTE_CATEGORIES,
                        JSONHelper.getJSONFromI18nMap(activityCourse.getActivity().getTitleMap())
                );

                jsonActivityCourse.put(
                        Constants.ATTRIBUTE_LINK_ABSOLUTE,
                        themeDisplay.getPortalURL() + Utils.getHomeURL(themeDisplay) + Constants.DETAIL_COURSE_URL + activityCourse.getActivityCourseId()
                );

                jsonActivityCourse.put(
                        Constants.ATTRIBUTE_ID,
                        activityCourse.getActivityCourseId()
                        );

                jsonActivityCourse.put(
                        Constants.ATTRIBUTE_TITLE,
                        activityCourse.getName(locale)
                );
                break;
        }

        return jsonActivityCourse;
    }

    /**
     * création de JSON pour Activity
     */
    public static JSONObject createActivitySearchJson(Activity activity, Locale locale, ThemeDisplay themeDisplay, String configAffichage){
        JSONObject jsonActivity = JSONFactoryUtil.createJSONObject();

        jsonActivity.put(
                Constants.ATTRIBUTE_CLASSNAME,
                Activity.class.getName()
        );

        jsonActivity.put(
                Constants.ATTRIBUTE_LINK,
                Utils.getHomeURL(themeDisplay) + Constants.DETAIL_ACTIVITY_URL + activity.getActivityId()
        );

        switch (configAffichage) {
            case Constants.SEARCH_FORM_PLACIT:
                break;
            case Constants.SEARCH_FORM_STRASBOURG:
                jsonActivity.put(
                        Constants.ATTRIBUTE_CATEGORIES,
                        activity.getTypesLabel(locale)
                );

                jsonActivity.put(
                        Constants.ATTRIBUTE_LINK_ABSOLUTE,
                        themeDisplay.getPortalURL() + Utils.getHomeURL(themeDisplay) + Constants.DETAIL_ACTIVITY_URL + activity.getActivityId()
                );

                jsonActivity.put(
                        Constants.ATTRIBUTE_TITLE,
                        activity.getTitle(locale)
                );

                jsonActivity.put(
                        Constants.ATTRIBUTE_ID,
                        activity.getActivityId()
                );

                jsonActivity.put(
                        Constants.ATTRIBUTE_DESCRIPTION,
                        activity.getDescription(locale).replace("\"/documents/",
                                "\"" + StrasbourgPropsUtil.getURL() + "/documents/")
                );
                break;
        }

        return jsonActivity;
    }
}
