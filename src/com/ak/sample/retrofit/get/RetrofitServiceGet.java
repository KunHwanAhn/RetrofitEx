package com.ak.sample.retrofit.get;

import static com.ak.sample.retrofit.utils.Constants.*;

import java.util.List;
import java.util.Map;

import com.ak.sample.retrofit.data.Gateway;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.http.QueryMap;

public interface RetrofitServiceGet {

    @GET(GATEWAYS)
    Call<JsonArray> getGateways(
            @Header(HEADER_AUTHORIZATION) String oauthAccessToken);

    @GET(GATEWAYS)
    Call<List<Gateway>> getGatewaysWithDataClass(
            @Header(HEADER_AUTHORIZATION) String oauthAccessToken);

    @GET(GATEWAYS_SLASH + GATEWAY_ID_PATH)
    Call<JsonObject> getGateway(
            @Header(HEADER_AUTHORIZATION) String oauthAccessToken,
            @Path(GATEWAY_ID) String gatewayId);

    @GET(GATEWAYS)
    Call<JsonObject> getGateways(
            @Header(HEADER_AUTHORIZATION) String oauthAccessToken,
            @Query(QUERY_GATEWAY_COUNT) int count);

    @GET(GATEWAYS)
    Call<JsonArray> getGateways(
            @Header(HEADER_AUTHORIZATION) String oauthAccessToken,
            @Query(QUERY_GATEWAY_FIELDS) List<String> fields);

    @GET(GATEWAYS)
    Call<JsonObject> getGateways(
            @Header(HEADER_AUTHORIZATION) String oauthAccessToken,
            @QueryMap Map<String, String> queries);

}
