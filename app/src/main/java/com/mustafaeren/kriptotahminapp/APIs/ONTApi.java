package com.mustafaeren.kriptotahminapp.APIs;

import com.mustafaeren.kriptotahminapp.Models.BNBModeli;
import com.mustafaeren.kriptotahminapp.Models.ONTModeli;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ONTApi {


    @GET("person/ONTUSDT")
    Call<ONTModeli> getData();
}
