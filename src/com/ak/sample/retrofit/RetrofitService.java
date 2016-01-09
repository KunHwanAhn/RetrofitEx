package com.ak.sample.retrofit;

import static com.ak.sample.retrofit.utils.Constants.*;

import java.util.List;

import com.ak.sample.retrofit.data.Gateway;
import com.google.gson.JsonArray;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Header;

public interface RetrofitService {

    @GET(GATEWAYS)
    Call<JsonArray> getGateways(@Header(HEADER_AUTHORIZATION) String oauthAccessToken);

    @GET(GATEWAYS)
    Call<List<Gateway>> getGatewaysWithDataClass(@Header(HEADER_AUTHORIZATION) String oauthAccessToken);
}
