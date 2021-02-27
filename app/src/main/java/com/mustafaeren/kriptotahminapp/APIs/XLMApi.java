package com.mustafaeren.kriptotahminapp.APIs;

import com.mustafaeren.kriptotahminapp.Models.BNBModeli;
import com.mustafaeren.kriptotahminapp.Models.XLMModeli;

import retrofit2.Call;
import retrofit2.http.GET;

public interface XLMApi {


    @GET("person/XLMUSDT")
    Call<XLMModeli> getData();
}
