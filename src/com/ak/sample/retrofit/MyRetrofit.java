package com.ak.sample.retrofit;

import static com.ak.sample.retrofit.utils.Constants.ERROR_AUTHORIZATION_STRING;
import static com.ak.sample.retrofit.utils.Constants.ERROR_CLIENT_ERROR_STRING;
import static com.ak.sample.retrofit.utils.Constants.ERROR_FAILED_TO_SEND_TO_SERVER;
import static com.ak.sample.retrofit.utils.Constants.ERROR_JSON_SYNTAX_ERROR_STRING;
import static com.ak.sample.retrofit.utils.Constants.ERROR_SERVER_ERROR_STRING;
import static com.ak.sample.retrofit.utils.Constants.ERROR_UNEXPECTED_ERRORS_OCCURS;
import static com.ak.sample.retrofit.utils.Constants.HTTP_CODE_AUTHORIZATION_ERROR;
import static com.ak.sample.retrofit.utils.Constants.HTTP_CODE_CLIENT_ERROR;
import static com.ak.sample.retrofit.utils.Constants.HTTP_CODE_SERVER_ERROR;
import static com.ak.sample.retrofit.utils.Constants.REQUEST_URL;
import static com.ak.sample.retrofit.utils.Constants.RESPONSE_BODY;

import java.io.IOException;
import java.util.concurrent.Semaphore;

import com.ak.sample.retrofit.get.CallbackEmail;
import com.ak.sample.retrofit.get.RetrofitWrapperGet;
import com.google.gson.JsonArray;
import com.google.gson.JsonSyntaxException;

import retrofit.Response;

public class MyRetrofit {
    private Semaphore mLock;
    private RetrofitWrapperGet mGetWrapper;

    public MyRetrofit(String oauthAccessToken) {
        mLock = new Semaphore(1);
        mGetWrapper = new RetrofitWrapperGet(oauthAccessToken);
    }

    /**
     * Get a list of user emails synchronously and print result<br/>
     * Please refer <a href=
     * "https://developer.github.com/v3/users/emails/#list-email-addresses-for-a-user">
     * Github Rest API document</a>
     */
    public void getUserEmailsSync() {
        try {
            mLock.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("==GET user/emails sync==");
        try {
            Response<JsonArray> response = mGetWrapper.getUserEmails();
            System.out.println(REQUEST_URL + response.raw().request().url().toString());
            if (response.body() != null) {
                System.out.println(RESPONSE_BODY + response.body().toString());
            } else if (response.code() >= HTTP_CODE_CLIENT_ERROR && response.code() < HTTP_CODE_SERVER_ERROR) {
                if (response.code() == HTTP_CODE_AUTHORIZATION_ERROR) {
                    System.out.println(ERROR_AUTHORIZATION_STRING);
                } else {
                    System.out.println(ERROR_CLIENT_ERROR_STRING);
                }
            } else if (response.code() >= HTTP_CODE_SERVER_ERROR) {
                System.out.println(ERROR_SERVER_ERROR_STRING);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println(ERROR_FAILED_TO_SEND_TO_SERVER);
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            System.out.println(ERROR_JSON_SYNTAX_ERROR_STRING);
            e.printStackTrace();
        } catch (RuntimeException e) {
            System.out.println(ERROR_UNEXPECTED_ERRORS_OCCURS);
            e.printStackTrace();
        }
        System.out.println();
        mLock.release();
    }

    /**
     * Get a list of user emails asynchronously and print result<br/>
     * Please refer <a href=
     * "https://developer.github.com/v3/users/emails/#list-email-addresses-for-a-user">
     * Github Rest API document</a>
     */
    public void getUserEmailsAsync() {
        try {
            mLock.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mGetWrapper.getUserEmails(new CallbackJsonArray(mLock, "==GET user/emails async=="));
    }

    /**
     * Get a list of user emails with data class asynchronously and print result
     * <br/>
     * Please refer <a href=
     * "https://developer.github.com/v3/users/emails/#list-email-addresses-for-a-user">
     * Github Rest API document</a>
     */
    public void getUserEmailsWithDataClass() {
        try {
            mLock.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mGetWrapper.getUserEmailsWithDataClass(new CallbackEmail(mLock, "==GET user/emails async=="));
    }
}
