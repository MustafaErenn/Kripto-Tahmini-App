package com.mustafaeren.kriptotahminapp.APIs;

import com.mustafaeren.kriptotahminapp.Models.BNBModeli;
import com.mustafaeren.kriptotahminapp.Models.BTCModeli;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BTCApi {


    @GET("person/BTCUSDT")
    Call<BTCModeli> getData();
}
