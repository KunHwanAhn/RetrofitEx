package com.ak.sample.retrofit.get;

import static com.ak.sample.retrofit.utils.Constants.*;

import java.util.List;

import com.ak.sample.retrofit.data.Email;
import com.google.gson.JsonArray;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;

public interface RetrofitServiceGet {

    @Headers({ HEADER_ACCEPT })
    @GET(USER_SLASH + EMAILS)
    Call<JsonArray> getUserEmails(@Header(HEADER_AUTHORIZATION) String oauthAccessToken);

    @Headers({ HEADER_ACCEPT })
    @GET(USER_SLASH + EMAILS)
    Call<List<Email>> getUserEmailsWithDataClass(@Header(HEADER_AUTHORIZATION) String oauthAccessToken);
}
