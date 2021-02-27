package com.mustafaeren.kriptotahminapp.APIs;

import com.mustafaeren.kriptotahminapp.Models.BNBModeli;
import com.mustafaeren.kriptotahminapp.Models.IOTAModeli;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IOTAApi {


    @GET("person/IOTAUSDT")
    Call<IOTAModeli> getData();
}
