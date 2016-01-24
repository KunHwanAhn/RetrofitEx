package com.ak.sample.retrofit.main;

import java.util.ArrayList;
import java.util.HashMap;

import com.ak.sample.retrofit.MyRetrofit;

public class Main {
    public static final String FIELD_NAME_ID = "id";
    public static final String FIELD_NAME_NAME = "name";
    public static final String FIELD_NAME_STATUS = "status";
    public static final String QUERY_COUNT = "count";
    public static final String QUERY_FIELDS = "fields";
    public static final String QUERY_EMBED = "embed";

    public static final String OAUTH2_ACCESS_TOKEN = "OAUTH2_ACCESS_TOKEN";
    public static final String GATEWAY_ID = "GATEWAY_ID";
    public static final int VALUE_COUNT = 2;
    public static final String VALUE_FIELD = "name";
    public static final String VALUE_EMBED = "status";

    public static void main(String[] args) throws InterruptedException {
        MyRetrofit myRetrofit = new MyRetrofit(OAUTH2_ACCESS_TOKEN);

        myRetrofit.getGatewaysSync();
        myRetrofit.getGatewaysAsync();
        myRetrofit.getGatewaysWithDataClassAsync();
        myRetrofit.getGatewayAsync(GATEWAY_ID);
        myRetrofit.getGateways(VALUE_COUNT);

        ArrayList<String> fieldNames = new ArrayList<>();
        fieldNames.add(FIELD_NAME_ID);
        fieldNames.add(FIELD_NAME_NAME);
        myRetrofit.getGateways(fieldNames);

        HashMap<String, String> queries = new HashMap<String, String>();
        queries.put(QUERY_COUNT, String.valueOf(VALUE_COUNT));
        queries.put(QUERY_EMBED, VALUE_EMBED);
        fieldNames.add(FIELD_NAME_STATUS);
        myRetrofit.getGateways(queries, fieldNames);
    }

}
