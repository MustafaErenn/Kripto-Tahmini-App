package com.mustafaeren.kriptotahminapp.APIs;

import com.mustafaeren.kriptotahminapp.Models.BANDModeli;
import com.mustafaeren.kriptotahminapp.Models.BNBModeli;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BANDApi {


    @GET("person/BANDUSDT")
    Call<BANDModeli> getData();
}
