package com.taka08.takashi.sampleretrofit2.rest;

import com.taka08.takashi.sampleretrofit2.rest.Pojo.CheckerPojo;
import com.taka08.takashi.sampleretrofit2.rest.Pojo.Sample.request.RequestSample;
import com.taka08.takashi.sampleretrofit2.rest.Pojo.Sample.response.ResponseSample;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface WeatherealmapServer {

    @POST("/sample")
    Call<ResponseSample> postSample(@Body RequestSample body);

    @GET("/checker")
    Call<CheckerPojo> checkServer();
}
