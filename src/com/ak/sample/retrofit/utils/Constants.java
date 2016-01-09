package com.ak.sample.retrofit.utils;

public class Constants {
    public static final String BASE_URL = "https://api.thingplus.net/v1/";
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final int HTTP_CODE_CLIENT_ERROR = 400;
    public static final int HTTP_CODE_SERVER_ERROR = 500;

    public static final String GATEWAYS = "gateways";
    public static final String SENSORS = "sensors";

    public static final String ERROR_CLIENT_ERROR_STRING = "Failed to get data, beacuse of client side error";
    public static final String ERROR_SERVER_ERROR_STRING = "Failed to get data, beacuse of server side error";
    public static final String ERROR_NETWORK_CONNECTION_STRING = "Failed to get data, beacuse of network connection";
}
