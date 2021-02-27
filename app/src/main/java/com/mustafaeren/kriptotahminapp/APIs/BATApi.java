package com.mustafaeren.kriptotahminapp.APIs;

import com.mustafaeren.kriptotahminapp.Models.BATModeli;
import com.mustafaeren.kriptotahminapp.Models.BNBModeli;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BATApi {


    @GET("person/BATUSDT")
    Call<BATModeli> getData();
}
