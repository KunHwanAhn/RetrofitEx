package com.ak.sample.retrofit.get;

import static com.ak.sample.retrofit.utils.Constants.ERROR_CLIENT_ERROR_STRING;
import static com.ak.sample.retrofit.utils.Constants.ERROR_NETWORK_CONNECTION_STRING;
import static com.ak.sample.retrofit.utils.Constants.ERROR_SERVER_ERROR_STRING;
import static com.ak.sample.retrofit.utils.Constants.HTTP_CODE_CLIENT_ERROR;
import static com.ak.sample.retrofit.utils.Constants.HTTP_CODE_SERVER_ERROR;

import java.util.List;
import java.util.concurrent.Semaphore;

import com.ak.sample.retrofit.data.Gateway;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class CallbackGateway implements Callback<List<Gateway>> {
    private Semaphore mLock;
    private String mTag;

    public CallbackGateway(Semaphore lock, String tag) {
        mLock = lock;
        mTag = tag;
    }

    @Override
    public void onFailure(Throwable throwable) {
        System.out.println(mTag);
        System.out.println(ERROR_NETWORK_CONNECTION_STRING);
        throwable.printStackTrace();
        System.out.println();
        mLock.release();
    }

    @Override
    public void onResponse(Response<List<Gateway>> response, Retrofit retrofit) {
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
