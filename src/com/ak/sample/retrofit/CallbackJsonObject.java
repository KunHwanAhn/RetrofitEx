package com.ak.sample.retrofit;

import static com.ak.sample.retrofit.utils.Constants.ERROR_CLIENT_ERROR_STRING;
import static com.ak.sample.retrofit.utils.Constants.ERROR_NETWORK_CONNECTION_STRING;
import static com.ak.sample.retrofit.utils.Constants.ERROR_SERVER_ERROR_STRING;
import static com.ak.sample.retrofit.utils.Constants.HTTP_CODE_CLIENT_ERROR;
import static com.ak.sample.retrofit.utils.Constants.HTTP_CODE_SERVER_ERROR;

import java.util.concurrent.Semaphore;

import com.google.gson.JsonObject;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class CallbackJsonObject implements Callback<JsonObject> {
    private Semaphore mLock;
    private String mTag;

    public CallbackJsonObject(Semaphore lock, String tag) {
        mLock = lock;
        mTag = tag;
    }

    @Override
    public void onFailure(Throwable throwable) {
        System.out.println(mTag);
        System.out.println(ERROR_NETWORK_CONNECTION_STRING);
        System.out.println();
        mLock.release();
    }

    @Override
    public void onResponse(Response<JsonObject> response, Retrofit retrofit) {
        System.out.println(mTag);
        if (response.body() != null) {
            System.out.println(response.body().toString());
        } else if (response.code() >= HTTP_CODE_CLIENT_ERROR && response.code() < HTTP_CODE_SERVER_ERROR) {
            System.out.println(ERROR_CLIENT_ERROR_STRING);
        } else if (response.code() >= HTTP_CODE_SERVER_ERROR) {
            System.out.println(ERROR_SERVER_ERROR_STRING);
        }
        System.out.println();
        mLock.release();
    }

}
