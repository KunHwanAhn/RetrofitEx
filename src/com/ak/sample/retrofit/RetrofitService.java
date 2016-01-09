package com.ak.sample.retrofit;

import static com.ak.sample.retrofit.utils.Constants.*;

import com.google.gson.JsonArray;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Header;

public interface RetrofitService {
    
    @GET(GATEWAYS)
    Call<JsonArray> getGateways(@Header(HEADER_AUTHORIZATION) String oauthAccessToken);
}
