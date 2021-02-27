package com.mustafaeren.kriptotahminapp.APIs;

import com.mustafaeren.kriptotahminapp.Models.BNBModeli;
import com.mustafaeren.kriptotahminapp.Models.ETHModeli;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ETHApi {


    @GET("person/ETHUSDT")
    Call<ETHModeli> getData();
}
