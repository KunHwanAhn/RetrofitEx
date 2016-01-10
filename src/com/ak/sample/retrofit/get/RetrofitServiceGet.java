package com.ak.sample.retrofit.get;

import static com.ak.sample.retrofit.utils.Constants.*;

import java.util.List;

import com.ak.sample.retrofit.data.Email;
import com.google.gson.JsonArray;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Header;

public interface RetrofitServiceGet {

    @GET(USER_SLASH + EMAILS)
    Call<JsonArray> getUser(@Header(HEADER_AUTHORIZATION) String oauthAccessToken);

    @GET(USER_SLASH + EMAILS)
    Call<List<Email>> getUserWithDataClass(@Header(HEADER_AUTHORIZATION) String oauthAccessToken);
}
