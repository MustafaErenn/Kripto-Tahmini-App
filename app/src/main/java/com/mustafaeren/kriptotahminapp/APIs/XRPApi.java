package com.mustafaeren.kriptotahminapp.APIs;

import com.mustafaeren.kriptotahminapp.Models.BNBModeli;
import com.mustafaeren.kriptotahminapp.Models.XRPModeli;

import retrofit2.Call;
import retrofit2.http.GET;

public interface XRPApi {


    @GET("person/XRPUSDT")
    Call<XRPModeli> getData();
}
