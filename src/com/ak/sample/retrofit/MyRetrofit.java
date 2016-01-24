package com.ak.sample.retrofit;

import static com.ak.sample.retrofit.utils.Constants.ERROR_AUTHORIZATION_STRING;
import static com.ak.sample.retrofit.utils.Constants.ERROR_FAILED_TO_SEND_TO_SERVER;
import static com.ak.sample.retrofit.utils.Constants.ERROR_UNEXPECTED_ERRORS_OCCURS;
import static com.ak.sample.retrofit.utils.Constants.REQUEST_URL;
import static com.ak.sample.retrofit.utils.Constants.RESPONSE_BODY;

import java.io.IOException;
import java.util.List;
import java.util.Map;
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
     * Get a list of gateways synchronously and print result<br/>
     * Please refer <a href="http://support.thingplus.net/ko/rest-api/rest-api.html#id-gateways">Thing+ Rest API document</a>
     */
    public void getGatewaysSync() {
        try {
            mLock.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("==GET gateways sync==");
        try {
            Response<JsonArray> response = mGetWrapper.getGateways();

            System.out.println(REQUEST_URL + response.raw().request().url().toString());
            System.out.println(RESPONSE_BODY + response.body().toString());
        } catch (NullPointerException e) {
            System.out.println(ERROR_AUTHORIZATION_STRING);
        } catch (IOException e) {
            System.out.println(ERROR_FAILED_TO_SEND_TO_SERVER);
            e.printStackTrace();
        } catch (RuntimeException e) {
            System.out.println(ERROR_UNEXPECTED_ERRORS_OCCURS);
            e.printStackTrace();
        }

        System.out.println();
        mLock.release();
    }

    /**
     * Get a list of gateways asynchronously and print result<br/>
     * Please refer <a href="http://support.thingplus.net/ko/rest-api/rest-api.html#id-gateways">Thing+ Rest API document</a>
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
     * {@link com.ak.sample.retrofit.data.Gateway}<br/>
     * Please refer <a href="http://support.thingplus.net/ko/rest-api/rest-api.html#id-gateways">Thing+ Rest API document</a>
     */
    public void getGatewaysWithDataClassAsync() {
        try {
            mLock.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mGetWrapper.getGatewaysWithDataClass(new CallbackGateway(mLock, "==GET gateways with Data class=="));
    }

    /**
     * Get a gateway asynchronously and print result<br/>
     * Please refer <a href="http://support.thingplus.net/ko/rest-api/rest-api.html#id-gateways">Thing+ Rest API document</a>
     * 
     * @param gatewayId
     *            gateway ID
     */
    public void getGatewayAsync(String gatewayId) {
        try {
            mLock.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mGetWrapper.getGateway(gatewayId, new CallbackJsonObject(mLock, "==GET gateways=="));
    }

    /**
     * Get gateways with count query<br/>
     * Please refer <a href="http://support.thingplus.net/ko/rest-api/rest-api.html#id-types">Thing+ Rest API document</a>
     * 
     * @param count
     *            the number of gateways you want to get
     */
    public void getGateways(int count) {
        try {
            mLock.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mGetWrapper.getGateways(count, new CallbackJsonObject(mLock, "==GET gateways with query=="));
    }

    /**
     * Get gateways with chosen field names<br/>
     * Please refer <a href="http://support.thingplus.net/ko/rest-api/rest-api.html#id-types">Thing+ Rest API document</a>
     * 
     * @param fieldNames
     *            chosen field names, such as id, name, status, etc
     */
    public void getGateways(List<String> fieldNames) {
        try {
            mLock.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mGetWrapper.getGateways(fieldNames, new CallbackJsonArray(mLock, "==GET gateways with field name queries=="));
    }

    /**
     * Get gateways with diverse queries<br/>
     * Please refer <a href="http://support.thingplus.net/ko/rest-api/rest-api.html#id-types">Thing+ Rest API document</a>
     * 
     * @param queries
     *            diverse queries, such as "count = 2", "embed = status"
     * @param fieldNames
     *            chosen field names, such as id, name, status, etc
     */
    public void getGateways(Map<String, String> queries, List<String> fieldNames) {
        try {
            mLock.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mGetWrapper.getGateways(queries, fieldNames, new CallbackJsonObject(mLock, "==GET gateways with queries=="));
    }
}
