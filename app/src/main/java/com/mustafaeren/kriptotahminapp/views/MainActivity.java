package com.mustafaeren.kriptotahminapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mustafaeren.kriptotahminapp.APIs.BNBApi;
import com.mustafaeren.kriptotahminapp.Adapters.CoinsAdapter;
import com.mustafaeren.kriptotahminapp.Models.BNBModeli;
import com.mustafaeren.kriptotahminapp.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    ArrayList<String> coinIsmiArrayList;
    CoinsAdapter coinsAdapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        coinIsmiArrayList = new ArrayList<>();







        coinIsmiArrayList.add("ETHUSDT");
        coinIsmiArrayList.add("BNBUSDT");
        coinIsmiArrayList.add("LTCUSDT");
        coinIsmiArrayList.add("NEOUSDT");
        coinIsmiArrayList.add("XRPUSDT");
        coinIsmiArrayList.add("ADAUSDT");
        coinIsmiArrayList.add("BELUSDT");
        coinIsmiArrayList.add("XLMUSDT");
        coinIsmiArrayList.add("BATUSDT");
        coinIsmiArrayList.add("LINKUSDT");
        coinIsmiArrayList.add("BANDUSDT");
        coinIsmiArrayList.add("ONTUSDT");
        coinIsmiArrayList.add("IOTAUSDT");

        RecyclerView recyclerView = findViewById(R.id.recycler_view_coins);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        coinsAdapter = new CoinsAdapter(coinIsmiArrayList);
        recyclerView.setAdapter(coinsAdapter);


    }

}