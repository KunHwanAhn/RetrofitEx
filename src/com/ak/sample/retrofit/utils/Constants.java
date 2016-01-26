package com.ak.sample.retrofit.utils;

public class Constants {
    public static final String BASE_URL = "https://api.github.com/";
    public static final String HEADER_ACCEPT = "Accept: application/vnd.github.v3+json";
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final int HTTP_CODE_CLIENT_ERROR = 400;
    public static final int HTTP_CODE_AUTHORIZATION_ERROR = 401;
    public static final int HTTP_CODE_SERVER_ERROR = 500;

    public static final String REQUEST_URL = "Request URL: ";
    public static final String RESPONSE_BODY = "Response BODY: ";

    public static final String USER = "user";
    public static final String USER_SLASH = "user/";
    public static final String EMAILS = "emails";

    public static final String ERROR_AUTHORIZATION_STRING = "Please check whether your OAuth2 AccessToken is correct or not";
    public static final String ERROR_CLIENT_ERROR_STRING = "Failed to get data, beacuse of client side error";
    public static final String ERROR_SERVER_ERROR_STRING = "Failed to get data, beacuse of server side error";
    public static final String ERROR_JSON_SYNTAX_ERROR_STRING = "Failed to get data, beacuse response json structre is different";
    public static final String ERROR_NETWORK_CONNECTION_STRING = "Failed to get data, beacuse of network connection";
    public static final String ERROR_FAILED_TO_SEND_TO_SERVER = "Failed to send data to server";
    public static final String ERROR_UNEXPECTED_ERRORS_OCCURS = "Unexpected error occurs";
}
