package com.ak.sample.retrofit.main;

import java.util.concurrent.Semaphore;

import com.ak.sample.retrofit.CallbackJsonArray;
import com.ak.sample.retrofit.get.CallbackGateway;
import com.ak.sample.retrofit.get.RetrofitWrapperGet;

public class Main {
    public static final String OAUTH2_ACCESS_TOKEN = "OAUTH2_ACCESS_TOKEN";
    public static final String GATEWAY_ID = "GATEWAY_ID";
    public static final int GATEWAY_QUERY_COUNT = 2;

    public static void main(String[] args) throws InterruptedException {
        Semaphore lock = new Semaphore(1);
        RetrofitWrapperGet wrapper = new RetrofitWrapperGet(OAUTH2_ACCESS_TOKEN);

        lock.acquire();
        wrapper.getGateways(new CallbackJsonArray(lock, "==GET gateways async=="));

        lock.acquire();
        wrapper.getGatewaysWithDataClass(new CallbackGateway(lock, "==GET gateways with Data class=="));
    }

}
