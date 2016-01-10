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
    private Retrofit mRetrofit;

    public RetrofitWrapperGet(String oauthAccessToken) {
        mOauthAccessToken = oauthAccessToken;

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    
    public void getGateways(Callback<JsonArray> callback) {
        Call<JsonArray> call = mRetrofit.create(RetrofitServiceGet.class).getGateways(mOauthAccessToken);
        call.enqueue(callback);
    }

    public void getGatewaysWithDataClass(Callback<List<Gateway>> callback) {
        Call<List<Gateway>> call = mRetrofit.create(RetrofitServiceGet.class).getGatewaysWithDataClass(mOauthAccessToken);
        call.enqueue(callback);
    }

}
