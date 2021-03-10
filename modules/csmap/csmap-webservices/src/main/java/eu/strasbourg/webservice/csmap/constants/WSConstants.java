package eu.strasbourg.webservice.csmap.constants;

public class WSConstants {

    /** Web service config */
    public static final String APP_GROUP_BASE = "/csmap-ws";
    public static final String APP_AUTH_BASE = "/auth";
    public static final String APP_AUTH_NAME = "CSMAP.Auth.Rest";
    public static final String APP_PLACE_BASE = "/place";
    public static final String APP_PLACE_NAME = "CSMAP.Place.Rest";
    public static final String APP_PROFILE_BASE = "/profile";
    public static final String APP_PROFILE_NAME = "CSMAP.Profile.Rest";

    /** Publik */
    public static final String REDIRECT_URI = "http://localhost:8080/static.html";
    public static final String ID_TOKEN = "id_token";
    public static final String ACCESS_TOKEN = "access_token";
    public static final String SUB = "sub";
    public static final String GIVEN_NAME = "given_name";
    public static final String FAMILY_NAME = "family_name";
    public static final String EMAIL = "email";

    /** Token config */
    public static final int TOKEN_LENGTH = 255;
    public static final int JWT_VALIDITY_SECONDS = 3600;
    public static final int JWT_VALIDITY_LEEWAY = 10;
    public static final String JWT_HEADER_NAME = "JWT_CSM";

    /** Paramètres */
    // Place
    public static final String PARAM_IDS_CATEGORY = "ids_category";
    public static final String PARAM_LAST_UPDATE_TIME_DEFAULT = "2000-01-01";

    /** JSON de réponse */
    // Global
    public static final String JSON_RESPONSE_CODE = "responseCode";
    public static final String JSON_ERROR_DESCRIPTION = "errorDescription";
    // Auth
    public static final String JSON_REFRESH_TOKEN = "refreshToken";
    public static final String JSON_JWT_CSM = "JWT_CSM";
    // Place
    public static final String JSON_ADD = "ADD";
    public static final String JSON_UPDATE = "UPDATE";
    public static final String JSON_DELETE = "DELETE";
    // Profil
    public static final String JSON_LAST_NAME = "lastname";
    public static final String JSON_FIRST_NAME = "firstname";
    public static final String JSON_EMAIL = "email";
    public static final String JSON_ADDRESS = "address";
    public static final String JSON_POSTAL_CODE = "postalCode";
    public static final String JSON_CITY = "city";
    public static final String JSON_IMAGE_URL = "imageURL";

    /** Erreurs */
    // Global
    public static final String ERROR_NO_JWT_IN_HEADER = "No JWT in header";
    public static final String ERROR_INVALID_TOKEN = "Invalid token receives during authentication";
    public static final String ERROR_NO_SUB_IN_JWT = "No sub in JWT";
    public static final String ERROR_SUB_NOT_RECOGNISE = "Sub not recognise";
    // Auth
    public static final String ERROR_AUTHENTICATION = "An error occurs during Authentik authentication";
    public static final String ERROR_REFRESH_TOKEN_INVALID = "Refresh token invalid";
    public static final String ERROR_REFRESH_TOKEN_EXPIRED = "Refresh token is no longer valid";
    public static final String ERROR_REFREH_TOKEN_CREATION = "An error occurs during refresh token creation";
    // Place
    public static final String ERROR_NO_DEFAULT_PICTO = "No default picto available for this application";

}