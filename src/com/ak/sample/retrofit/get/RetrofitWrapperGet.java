package com.ak.sample.retrofit.get;

import static com.ak.sample.retrofit.utils.Constants.BASE_URL;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.ak.sample.retrofit.data.Gateway;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class RetrofitWrapperGet {
    private String mOauthAccessToken;
    private RetrofitServiceGet mService;

    public RetrofitWrapperGet(String oauthAccessToken) {
        mOauthAccessToken = oauthAccessToken;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        
        mService = retrofit.create(RetrofitServiceGet.class);
    }

    public void getGateways(Callback<JsonArray> callback) {
        Call<JsonArray> call = mService.getGateways(mOauthAccessToken);
        call.enqueue(callback);
    }

    public Response<JsonArray> getGateways() throws IOException, RuntimeException {
        Call<JsonArray> call = mService.getGateways(mOauthAccessToken);
        return call.execute();
    }

    public void getGatewaysWithDataClass(Callback<List<Gateway>> callback) {
        Call<List<Gateway>> call = mService.getGatewaysWithDataClass(mOauthAccessToken);
        call.enqueue(callback);
    }

    public void getGateway(String gatewayId, Callback<JsonObject> callback) {
        Call<JsonObject> call = mService.getGateway(mOauthAccessToken, gatewayId);
        call.enqueue(callback);
    }

    public void getGateways(int count, Callback<JsonObject> callback) {
        Call<JsonObject> call = mService.getGateways(mOauthAccessToken, count);
        call.enqueue(callback);
    }

    public void getGateways(List<String> fields, Callback<JsonArray> callback) {
        Call<JsonArray> call = mService.getGateways(mOauthAccessToken, fields);
        call.enqueue(callback);
    }
    
    public void getGateways(Map<String, String> queries, List<String> fieldNames, Callback<JsonObject> callback) {
        Call<JsonObject> call = null;
        if (fieldNames == null) {
            call = mService.getGateways(mOauthAccessToken, queries);
        } else {
            call = mService.getGateways(mOauthAccessToken, queries, fieldNames);
        }
        call.enqueue(callback);
    }
}
