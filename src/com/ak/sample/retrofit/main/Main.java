package com.ak.sample.retrofit.main;

import com.ak.sample.retrofit.RetrofitWrapper;
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
                // TODO Auto-generated method stub
                if (response.body() != null) {
                    System.out.println("Success");
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                // TODO Auto-generated method stub

            }
        });
    }

}
