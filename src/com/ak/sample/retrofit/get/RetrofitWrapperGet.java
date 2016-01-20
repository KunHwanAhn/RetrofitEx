package com.ak.sample.retrofit.get;

import static com.ak.sample.retrofit.utils.Constants.*;

import java.util.List;

import com.ak.sample.retrofit.data.Email;
import com.google.gson.JsonArray;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class RetrofitWrapperGet {
    private String mOAuthAccessToken;
    private RetrofitServiceGet mService;

    public RetrofitWrapperGet(String oauthAccessToken) {
        mOAuthAccessToken = oauthAccessToken;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mService = retrofit.create(RetrofitServiceGet.class);
    }

    public void getUser(Callback<JsonArray> callback) {
        Call<JsonArray> call = mService.getUser(mOAuthAccessToken);
        call.enqueue(callback);
    }

    public void getUserWithDataClass(Callback<List<Email>> callback) {
        Call<List<Email>> call = mService.getUserWithDataClass(mOAuthAccessToken);
        call.enqueue(callback);
    }

}
