package com.mustafaeren.kriptotahminapp.APIs;

import com.mustafaeren.kriptotahminapp.Models.ADAModeli;
import com.mustafaeren.kriptotahminapp.Models.BNBModeli;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ADAApi {


    @GET("person/ADAUSDT")
    Call<ADAModeli> getData();
}
