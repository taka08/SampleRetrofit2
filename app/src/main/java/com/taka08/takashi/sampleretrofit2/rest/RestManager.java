package com.taka08.takashi.sampleretrofit2.rest;

import com.taka08.takashi.sampleretrofit2.rest.Pojo.CheckerPojo;
import com.taka08.takashi.sampleretrofit2.rest.Pojo.Sample.request.RequestSample;
import com.taka08.takashi.sampleretrofit2.rest.Pojo.Sample.response.ResponseSample;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ragro on 2017/04/06.
 */

public class RestManager {
    private final String BASE_URL = "http://weatherealmap.hamalab.org/";
    private Retrofit _retrofit;
    private WeatherealmapServer _service;

    public RestManager(){
        _retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        _service = _retrofit.create(WeatherealmapServer.class);
    }

    public void serverCheck(Callback<CheckerPojo> listener){
        Call<CheckerPojo> call = _service.checkServer();
        call.enqueue(listener);

    }

    public void postSample(RequestSample sample, Callback<ResponseSample> listener) {
        Call<ResponseSample> call = _service.postSample(sample);
        call.enqueue(listener);
    }
}