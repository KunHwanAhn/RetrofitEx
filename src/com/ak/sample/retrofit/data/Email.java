package com.ak.sample.retrofit.data;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class Email {
    private static final String EMAIL = "email";
    private static final String PRIMARY = "primary";
    private static final String VERIFIED = "verified";

    @SerializedName(EMAIL)
    private String mMailAddress;

    @SerializedName(PRIMARY)
    private boolean mIsPrimary;

    @SerializedName(VERIFIED)
    private boolean mIsVerified;

    public String getMailAddress() {
        return mMailAddress;
    }

    public boolean isPrimaryMail() {
        return mIsPrimary;
    }

    public boolean isVerifiedMail() {
        return mIsVerified;
    }

    @Override
    public String toString() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(EMAIL, mMailAddress);
        jsonObject.addProperty(PRIMARY, mIsPrimary);
        jsonObject.addProperty(VERIFIED, mIsVerified);

        return jsonObject.toString();
    }

}
