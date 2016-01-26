package com.ak.sample.retrofit.get;

import static com.ak.sample.retrofit.utils.Constants.ERROR_AUTHORIZATION_STRING;
import static com.ak.sample.retrofit.utils.Constants.ERROR_CLIENT_ERROR_STRING;
import static com.ak.sample.retrofit.utils.Constants.ERROR_JSON_SYNTAX_ERROR_STRING;
import static com.ak.sample.retrofit.utils.Constants.ERROR_NETWORK_CONNECTION_STRING;
import static com.ak.sample.retrofit.utils.Constants.ERROR_SERVER_ERROR_STRING;
import static com.ak.sample.retrofit.utils.Constants.HTTP_CODE_AUTHORIZATION_ERROR;
import static com.ak.sample.retrofit.utils.Constants.HTTP_CODE_CLIENT_ERROR;
import static com.ak.sample.retrofit.utils.Constants.HTTP_CODE_SERVER_ERROR;
import static com.ak.sample.retrofit.utils.Constants.REQUEST_URL;
import static com.ak.sample.retrofit.utils.Constants.RESPONSE_BODY;

import java.util.List;
import java.util.concurrent.Semaphore;

import com.ak.sample.retrofit.data.Email;
import com.google.gson.JsonSyntaxException;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class CallbackEmail implements Callback<List<Email>> {
    private Semaphore mLock;
    private String mTag;

    public CallbackEmail(Semaphore lock, String tag) {
        mLock = lock;
        mTag = tag;
    }

    @Override
    public void onFailure(Throwable throwable) {
        System.out.println(mTag);
        if (throwable instanceof JsonSyntaxException) {
            System.out.println(ERROR_JSON_SYNTAX_ERROR_STRING);
        } else {
            System.out.println(ERROR_NETWORK_CONNECTION_STRING);
        }
        throwable.printStackTrace();
        System.out.println();
        mLock.release();
    }

    @Override
    public void onResponse(Response<List<Email>> response, Retrofit retrofit) {
        System.out.println(mTag);
        System.out.println(REQUEST_URL + response.raw().request().url().toString());
        if (response.body() != null) {
            System.out.println(RESPONSE_BODY + response.body().toString());
        } else if (response.code() >= HTTP_CODE_CLIENT_ERROR && response.code() < HTTP_CODE_SERVER_ERROR) {
            if (response.code() == HTTP_CODE_AUTHORIZATION_ERROR) {
                System.out.println(ERROR_AUTHORIZATION_STRING);
            } else {
                System.out.println(ERROR_CLIENT_ERROR_STRING);
            }
        } else if (response.code() >= HTTP_CODE_SERVER_ERROR) {
            System.out.println(ERROR_SERVER_ERROR_STRING);
        }
        System.out.println();
        mLock.release();
    }

}
