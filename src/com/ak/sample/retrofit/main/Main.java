package com.ak.sample.retrofit.main;

import static com.ak.sample.retrofit.utils.Constants.ERROR_CLIENT_ERROR_STRING;
import static com.ak.sample.retrofit.utils.Constants.ERROR_NETWORK_CONNECTION_STRING;
import static com.ak.sample.retrofit.utils.Constants.ERROR_SERVER_ERROR_STRING;
import static com.ak.sample.retrofit.utils.Constants.HTTP_CODE_CLIENT_ERROR;
import static com.ak.sample.retrofit.utils.Constants.HTTP_CODE_SERVER_ERROR;

import java.util.List;

import com.ak.sample.retrofit.RetrofitWrapper;
import com.ak.sample.retrofit.data.Gateway;
import com.google.gson.JsonArray;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class Main {
    public static final String OAUTH2_ACCESS_TOKEN = "OAUTH2_ACCESS_TOKEN";

    public static void main(String[] args) {
        RetrofitWrapper wrapper = new RetrofitWrapper(OAUTH2_ACCESS_TOKEN);

        wrapper.getGateways(new Callback<JsonArray>() {

            @Override
            public void onResponse(Response<JsonArray> response, Retrofit retrofit) {
                if (response.body() != null) {
                    System.out.println(response.body().toString());
                } else if (response.code() >= HTTP_CODE_CLIENT_ERROR
                        && response.code() < HTTP_CODE_SERVER_ERROR) {
                    System.out.println(ERROR_CLIENT_ERROR_STRING);
                } else if (response.code() >= HTTP_CODE_SERVER_ERROR) {
                    System.out.println(ERROR_SERVER_ERROR_STRING);
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println(ERROR_NETWORK_CONNECTION_STRING);
            }
        });

        wrapper.getGatewaysWithDataClass(new Callback<List<Gateway>>() {

            @Override
            public void onResponse(Response<List<Gateway>> response, Retrofit retrofit) {
                if (response.body() != null) {
                    System.out.println(response.body().toString());
                } else if (response.code() >= HTTP_CODE_CLIENT_ERROR
                        && response.code() < HTTP_CODE_SERVER_ERROR) {
                    System.out.println(ERROR_CLIENT_ERROR_STRING);
                } else if (response.code() >= HTTP_CODE_SERVER_ERROR) {
                    System.out.println(ERROR_SERVER_ERROR_STRING);
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println(ERROR_NETWORK_CONNECTION_STRING);
            }
        });
    }

}
