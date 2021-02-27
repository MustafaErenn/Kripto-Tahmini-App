package com.mustafaeren.kriptotahminapp.APIs;

import com.mustafaeren.kriptotahminapp.Models.BNBModeli;
import com.mustafaeren.kriptotahminapp.Models.NEOModeli;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NEOApi {


    @GET("person/NEOUSDT")
    Call<NEOModeli> getData();
}
