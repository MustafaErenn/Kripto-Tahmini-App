package com.mustafaeren.kriptotahminapp.APIs;

import com.mustafaeren.kriptotahminapp.Models.BNBModeli;
import com.mustafaeren.kriptotahminapp.Models.LTCModeli;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LTCApi {


    @GET("person/LTCUSDT")
    Call<LTCModeli> getData();
}
