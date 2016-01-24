package com.ak.sample.retrofit.main;

import com.ak.sample.retrofit.MyRetrofit;

public class Main {
    public static final String OAUTH2_ACCESS_TOKEN = "OAUTH2_ACCESS_TOKEN";
    public static final String GATEWAY_ID = "GATEWAY_ID";
    public static final int GATEWAY_QUERY_COUNT = 2;

    public static void main(String[] args) throws InterruptedException {
        MyRetrofit myRetrofit = new MyRetrofit(OAUTH2_ACCESS_TOKEN);
        
        myRetrofit.getGatewaysSync();
        myRetrofit.getGatewaysAsync();
        myRetrofit.getGatewaysWithDataClass();
    }

}
