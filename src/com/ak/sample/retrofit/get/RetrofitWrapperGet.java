package com.ak.sample.retrofit.get;

import static com.ak.sample.retrofit.utils.Constants.BASE_URL;

import java.util.List;

import com.ak.sample.retrofit.data.Gateway;
import com.google.gson.JsonArray;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
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

    public void getGatewaysWithDataClass(Callback<List<Gateway>> callback) {
        Call<List<Gateway>> call = mService.getGatewaysWithDataClass(mOauthAccessToken);
        call.enqueue(callback);
    }

}
