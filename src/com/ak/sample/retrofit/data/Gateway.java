package com.ak.sample.retrofit.data;

import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class Gateway {
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SENSORS = "sensors";
    private static final String REPORT_INTERVAL = "reportInterval";

    @SerializedName(ID)
    private String mId;

    @SerializedName(NAME)
    private String mName;

    @SerializedName(SENSORS)
    private List<String> mSensorIds;

    @SerializedName(REPORT_INTERVAL)
    private String mReportInterval;

    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public List<String> getSensorsIds() {
        return mSensorIds;
    }

    public long getReportInterval() {
        return Long.valueOf(mReportInterval);
    }

    @Override
    public String toString() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(ID, mId);
        jsonObject.addProperty(NAME, mName);
        JsonArray sensorIds = new JsonArray();
        for (String sensorId : mSensorIds) {
            sensorIds.add(sensorId);
        }
        jsonObject.add(SENSORS, sensorIds); 
        jsonObject.addProperty(REPORT_INTERVAL, Long.valueOf(mReportInterval));

        return jsonObject.toString();
    }

}
