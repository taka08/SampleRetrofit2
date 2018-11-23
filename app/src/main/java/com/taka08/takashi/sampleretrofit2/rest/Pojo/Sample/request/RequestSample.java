package com.taka08.takashi.sampleretrofit2.rest.Pojo.Sample.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestSample {
    @SerializedName("samplereq")
    @Expose
    public Boolean sample;
}
