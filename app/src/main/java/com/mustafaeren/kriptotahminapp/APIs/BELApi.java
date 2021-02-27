package com.mustafaeren.kriptotahminapp.APIs;

import com.mustafaeren.kriptotahminapp.Models.BELModeli;
import com.mustafaeren.kriptotahminapp.Models.BNBModeli;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BELApi {


    @GET("person/BELUSDT")
    Call<BELModeli> getData();
}
