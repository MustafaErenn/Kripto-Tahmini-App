package com.mustafaeren.kriptotahminapp.APIs;

import com.mustafaeren.kriptotahminapp.Models.BNBModeli;
import com.mustafaeren.kriptotahminapp.Models.LINKModeli;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LINKApi {


    @GET("person/LINKUSDT")
    Call<LINKModeli> getData();
}
