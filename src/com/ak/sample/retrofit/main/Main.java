package com.ak.sample.retrofit.main;

import java.util.concurrent.Semaphore;

import com.ak.sample.retrofit.CallbackJsonArray;
import com.ak.sample.retrofit.get.CallbackEmail;
import com.ak.sample.retrofit.get.RetrofitWrapperGet;

public class Main {
    public static final String OAUTH2_ACCESS_TOKEN = "OAUTH2_ACCESS_TOKEN";

    public static void main(String[] args) throws InterruptedException {
        Semaphore lock = new Semaphore(1);
        
        lock.acquire();
        RetrofitWrapperGet wrapper = new RetrofitWrapperGet(OAUTH2_ACCESS_TOKEN);
        wrapper.getUser(new CallbackJsonArray(lock, "===GET USER==="));

        lock.acquire();
        wrapper.getUserWithDataClass(new CallbackEmail(lock, "===GET USER with data object==="));
    }

}
