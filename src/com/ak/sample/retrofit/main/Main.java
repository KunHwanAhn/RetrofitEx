package com.ak.sample.retrofit.main;

import com.ak.sample.retrofit.MyRetrofit;

public class Main {
    public static final String OAUTH2_ACCESS_TOKEN = "OAUTH2_ACCESS_TOKEN";

    public static void main(String[] args) {
        MyRetrofit myRetrofit = new MyRetrofit(OAUTH2_ACCESS_TOKEN);

        myRetrofit.getUserEmailsSync();
        myRetrofit.getUserEmailsAsync();
        myRetrofit.getUserEmailsWithDataClass();
    }

}
