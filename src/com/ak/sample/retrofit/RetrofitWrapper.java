package com.ak.sample.retrofit;

import static com.ak.sample.retrofit.utils.Constants.BASE_URL;

import com.google.gson.JsonArray;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class RetrofitWrapper {
    private String mOauthAccessToken;
    private Retrofit mRetrofit;

    public RetrofitWrapper(String oauthAccessToken) {
        mOauthAccessToken = oauthAccessToken;

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    
    public void getGateways(Callback<JsonArray> callback) {
        Call<JsonArray> call = mRetrofit.create(RetrofitService.class).getGateways(mOauthAccessToken);
        call.enqueue(callback);
    }

}
