package com.ak.sample.retrofit;

import static com.ak.sample.retrofit.utils.Constants.ERROR_FAILED_TO_SEND_TO_SERVER;
import static com.ak.sample.retrofit.utils.Constants.ERROR_UNEXPECTED_ERRORS_OCCURS;

import java.io.IOException;
import java.util.concurrent.Semaphore;

import com.ak.sample.retrofit.get.CallbackGateway;
import com.ak.sample.retrofit.get.RetrofitWrapperGet;
import com.google.gson.JsonArray;

import retrofit.Response;

public class MyRetrofit {
    private Semaphore mLock;
    private RetrofitWrapperGet mGetWrapper;

    public MyRetrofit(String oauthAccessToken) {
        mLock = new Semaphore(1);
        mGetWrapper = new RetrofitWrapperGet(oauthAccessToken);
    }

    /**
     * Get a list of gateways synchronously and print result
     */
    public void getGatewaysSync() {
        try {
            mLock.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Response<JsonArray> response = mGetWrapper.getGateways();
            System.out.println("==GET gateways sync==");
            System.out.println(response.body().toString());
            System.out.println();
            mLock.release();
        } catch (IOException e) {
            System.out.println("==GET gateways sync==");
            System.out.println(ERROR_FAILED_TO_SEND_TO_SERVER);
            e.printStackTrace();
            mLock.release();
        } catch (RuntimeException e) {
            System.out.println("==GET gateways sync==");
            System.out.println(ERROR_UNEXPECTED_ERRORS_OCCURS);
            e.printStackTrace();
            mLock.release();
        }
    }

    /**
     * Get a list of gateways asynchronously and print result
     */
    public void getGatewaysAsync() {
        try {
            mLock.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mGetWrapper.getGateways(new CallbackJsonArray(mLock, "==GET gateways async=="));
    }

    /**
     * Get a list of gateways with data class asynchronously and print result,
     * {@link com.ak.sample.retrofit.data.Gateway}
     */
    public void getGatewaysWithDataClass() {
        try {
            mLock.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mGetWrapper.getGatewaysWithDataClass(new CallbackGateway(mLock, "==GET gateways with Data class=="));
    }
}
