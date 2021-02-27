package com.mustafaeren.kriptotahminapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mustafaeren.kriptotahminapp.APIs.ADAApi;
import com.mustafaeren.kriptotahminapp.APIs.BANDApi;
import com.mustafaeren.kriptotahminapp.APIs.BATApi;
import com.mustafaeren.kriptotahminapp.APIs.BELApi;
import com.mustafaeren.kriptotahminapp.APIs.BNBApi;
import com.mustafaeren.kriptotahminapp.APIs.BTCApi;
import com.mustafaeren.kriptotahminapp.APIs.ETHApi;
import com.mustafaeren.kriptotahminapp.APIs.IOTAApi;
import com.mustafaeren.kriptotahminapp.APIs.LINKApi;
import com.mustafaeren.kriptotahminapp.APIs.LTCApi;
import com.mustafaeren.kriptotahminapp.APIs.NEOApi;
import com.mustafaeren.kriptotahminapp.APIs.ONTApi;
import com.mustafaeren.kriptotahminapp.APIs.XLMApi;
import com.mustafaeren.kriptotahminapp.APIs.XRPApi;
import com.mustafaeren.kriptotahminapp.Models.ADAModeli;
import com.mustafaeren.kriptotahminapp.Models.BANDModeli;
import com.mustafaeren.kriptotahminapp.Models.BATModeli;
import com.mustafaeren.kriptotahminapp.Models.BELModeli;
import com.mustafaeren.kriptotahminapp.Models.BNBModeli;
import com.mustafaeren.kriptotahminapp.Models.BTCModeli;
import com.mustafaeren.kriptotahminapp.Models.ETHModeli;
import com.mustafaeren.kriptotahminapp.Models.IOTAModeli;
import com.mustafaeren.kriptotahminapp.Models.LINKModeli;
import com.mustafaeren.kriptotahminapp.Models.LTCModeli;
import com.mustafaeren.kriptotahminapp.Models.NEOModeli;
import com.mustafaeren.kriptotahminapp.Models.ONTModeli;
import com.mustafaeren.kriptotahminapp.Models.XLMModeli;
import com.mustafaeren.kriptotahminapp.Models.XRPModeli;
import com.mustafaeren.kriptotahminapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoinTahminActivity extends AppCompatActivity {

    String coinAdi;
    private String BASE_URL= "http://10.0.2.2:5000/"; //
    Retrofit retrofit;
    TextView coinTitle;
    TextView acilisTitleText;
    TextView acilisText;
    TextView anlikDegerTitleText;
    TextView anlikDegerText;
    TextView tahminTitleText;
    TextView tahminText;

    ImageView coinLogosu;
    loading_dialog loading_dialogObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_tahmin);

        loading_dialogObj = new loading_dialog(CoinTahminActivity.this);


        coinLogosu=findViewById(R.id.coinLogosu);
        coinAdi = getIntent().getStringExtra("coinAdi");// hangi coinin tahminini yapmaya bastigini gostericek
        coinTitle = findViewById(R.id.coinTitle);
        acilisTitleText = findViewById(R.id.acilisTitleText);
        acilisText = findViewById(R.id.acilisText);
        anlikDegerTitleText = findViewById(R.id.anlikDegerTitleText);

        anlikDegerText = findViewById(R.id.anlikDegerText);
        tahminTitleText = findViewById(R.id.tahminTitleText);
        tahminText = findViewById(R.id.tahminText);

        //set textler

        acilisTitleText.setText("1 SAATLIK MUM ACILISI:");
        anlikDegerTitleText.setText("ANLIK DEGERI:");
        tahminTitleText.setText("1 SAATLIK MUM KAPANIS TAHMINI:");


        System.out.println("coin adi == "+coinAdi);
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder().
                baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        if(coinAdi.matches("BNBUSDT"))
        {
            coinTitle.setText("Binance Coin");
            getPriceBNBUSDT();
        }
        else if(coinAdi.matches("BTCUSDT"))
        {
            coinTitle.setText("Binance Coin");
            getPriceBTCUSDT();

        }
        else if(coinAdi.matches("ETHUSDT"))
        {
            coinTitle.setText("Ethereum");
            getPriceETHUSDT();

        }
//        else if(coinAdi.matches("BNBUSDT"))
//        {
//            getPriceBNBUSDT();
//
//        }
        else if(coinAdi.matches("LTCUSDT"))
        {
            coinTitle.setText("LiteCoin");
            getPriceLTCUSDT();

        }
        else if(coinAdi.matches("NEOUSDT"))
        {
            coinTitle.setText("NEO");
            getPriceNEOUSDT();

        }
        else if(coinAdi.matches("XRPUSDT"))
        {
            coinTitle.setText("Ripple");
            getPriceXRPUSDT();

        }
        else if(coinAdi.matches("ADAUSDT"))
        {
            coinTitle.setText("Cardano");
            getPriceADAUSDT();

        }
        else if(coinAdi.matches("BELUSDT"))
        {
            coinTitle.setText("Bella Protocol");
            getPriceBELUSDT();

        }
        else if(coinAdi.matches("XLMUSDT"))
        {
            coinTitle.setText("Stellar Lumens");
            getPriceXLMUSDT();

        }
        else if(coinAdi.matches("BATUSDT"))
        {
            coinTitle.setText("Basic Attention");
            getPriceBATUSDT();

        }
        else if(coinAdi.matches("LINKUSDT"))
        {
            coinTitle.setText("Chainlink");
            getPriceLINKUSDT();

        }
        else if(coinAdi.matches("BANDUSDT"))
        {
            coinTitle.setText("Band Protocol");
            getPriceBANDUSDT();

        }
        else if(coinAdi.matches("ONTUSDT"))
        {
            coinTitle.setText("Ontology");
            getPriceONTUSDT();

        }
        else if(coinAdi.matches("IOTAUSDT"))
        {
            coinTitle.setText("Iota");
            getPriceIOTAUSDT();

        }



        if(acilisText.getText().toString().matches(""))
        {
            loading_dialogObj.startLoading();
        }

    }

    public void anaSayfaButonu(View view)
    {
        Intent intent = new Intent(CoinTahminActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    private void getPriceBTCUSDT()
    {
        BTCApi kriptoApi = retrofit.create(BTCApi.class);

        Call<BTCModeli> call = kriptoApi.getData();

        call.enqueue(new Callback<BTCModeli>() {
            @Override
            public void onResponse(Call<BTCModeli> call, Response<BTCModeli> response) {

                if(response.isSuccessful())
                {

                    acilisText.setText(response.body().acilis);
                    anlikDegerText.setText(response.body().anlik);
                    tahminText.setText(response.body().tahmin);



                }

            }

            @Override
            public void onFailure(Call<BTCModeli> call, Throwable t) {
                System.out.println(t.getLocalizedMessage().toString());
            }


        });

    }
    private void getPriceETHUSDT()
    {
        ETHApi kriptoApi = retrofit.create(ETHApi.class);

        Call<ETHModeli> call = kriptoApi.getData();

        call.enqueue(new Callback<ETHModeli>() {
            @Override
            public void onResponse(Call<ETHModeli> call, Response<ETHModeli> response) {

                if(response.isSuccessful())
                {

                    acilisText.setText(response.body().acilis);
                    anlikDegerText.setText(response.body().anlik);
                    tahminText.setText(response.body().tahmin);

                    coinLogosu.setBackgroundResource(R.drawable.ethereum);
                    loading_dialogObj.dismissDialog();


                }

            }

            @Override
            public void onFailure(Call<ETHModeli> call, Throwable t) {
                System.out.println(t.getLocalizedMessage().toString());
            }


        });

    }
    private void getPriceBNBUSDT()
    {
        BNBApi kriptoApi = retrofit.create(BNBApi.class);

        Call<BNBModeli> call = kriptoApi.getData();

        call.enqueue(new Callback<BNBModeli>() {
            @Override
            public void onResponse(Call<BNBModeli> call, Response<BNBModeli> response) {

                if(response.isSuccessful())
                {

                    acilisText.setText(response.body().acilis);
                    anlikDegerText.setText(response.body().anlik);
                    tahminText.setText(response.body().tahmin);
                    coinLogosu.setBackgroundResource(R.drawable.binance);
                    loading_dialogObj.dismissDialog();

                }

            }

            @Override
            public void onFailure(Call<BNBModeli> call, Throwable t) {
                System.out.println(t.getLocalizedMessage().toString());
            }


        });

    }

    private void getPriceLTCUSDT()
    {
        LTCApi kriptoApi = retrofit.create(LTCApi.class);

        Call<LTCModeli> call = kriptoApi.getData();

        call.enqueue(new Callback<LTCModeli>() {
            @Override
            public void onResponse(Call<LTCModeli> call, Response<LTCModeli> response) {

                if(response.isSuccessful())
                {

                    acilisText.setText(response.body().acilis);
                    anlikDegerText.setText(response.body().anlik);
                    tahminText.setText(response.body().tahmin);
                    coinLogosu.setBackgroundResource(R.drawable.litecoin);
                    loading_dialogObj.dismissDialog();
                }

            }

            @Override
            public void onFailure(Call<LTCModeli> call, Throwable t) {
                System.out.println(t.getLocalizedMessage().toString());
            }


        });

    }

    private void getPriceNEOUSDT()
    {
        NEOApi kriptoApi = retrofit.create(NEOApi.class);

        Call<NEOModeli> call = kriptoApi.getData();

        call.enqueue(new Callback<NEOModeli>() {
            @Override
            public void onResponse(Call<NEOModeli> call, Response<NEOModeli> response) {

                if(response.isSuccessful())
                {

                    acilisText.setText(response.body().acilis);
                    anlikDegerText.setText(response.body().anlik);
                    tahminText.setText(response.body().tahmin);
                    coinLogosu.setBackgroundResource(R.drawable.neocoin);
                    loading_dialogObj.dismissDialog();

                }

            }

            @Override
            public void onFailure(Call<NEOModeli> call, Throwable t) {
                System.out.println(t.getLocalizedMessage().toString());
            }


        });

    }

    private void getPriceXRPUSDT()
    {
        XRPApi kriptoApi = retrofit.create(XRPApi.class);

        Call<XRPModeli> call = kriptoApi.getData();

        call.enqueue(new Callback<XRPModeli>() {
            @Override
            public void onResponse(Call<XRPModeli> call, Response<XRPModeli> response) {

                if(response.isSuccessful())
                {

                    acilisText.setText(response.body().acilis);
                    anlikDegerText.setText(response.body().anlik);
                    tahminText.setText(response.body().tahmin);
                    coinLogosu.setBackgroundResource(R.drawable.xrpcoin);
                    loading_dialogObj.dismissDialog();

                }

            }

            @Override
            public void onFailure(Call<XRPModeli> call, Throwable t) {
                System.out.println(t.getLocalizedMessage().toString());
            }


        });

    }

    private void getPriceADAUSDT()
    {
        ADAApi kriptoApi = retrofit.create(ADAApi.class);

        Call<ADAModeli> call = kriptoApi.getData();

        call.enqueue(new Callback<ADAModeli>() {
            @Override
            public void onResponse(Call<ADAModeli> call, Response<ADAModeli> response) {

                if(response.isSuccessful())
                {

                    acilisText.setText(response.body().acilis);
                    anlikDegerText.setText(response.body().anlik);
                    tahminText.setText(response.body().tahmin);
                    coinLogosu.setBackgroundResource(R.drawable.adacoin);
                    loading_dialogObj.dismissDialog();

                }

            }

            @Override
            public void onFailure(Call<ADAModeli> call, Throwable t) {
                System.out.println(t.getLocalizedMessage().toString());
            }


        });

    }

    private void getPriceBELUSDT()
    {
        BELApi kriptoApi = retrofit.create(BELApi.class);

        Call<BELModeli> call = kriptoApi.getData();

        call.enqueue(new Callback<BELModeli>() {
            @Override
            public void onResponse(Call<BELModeli> call, Response<BELModeli> response) {

                if(response.isSuccessful())
                {

                    acilisText.setText(response.body().acilis);
                    anlikDegerText.setText(response.body().anlik);
                    tahminText.setText(response.body().tahmin);
                    coinLogosu.setBackgroundResource(R.drawable.belcoin);
                    loading_dialogObj.dismissDialog();

                }

            }

            @Override
            public void onFailure(Call<BELModeli> call, Throwable t) {
                System.out.println(t.getLocalizedMessage().toString());
            }


        });

    }

    private void getPriceXLMUSDT()
    {
        XLMApi kriptoApi = retrofit.create(XLMApi.class);

        Call<XLMModeli> call = kriptoApi.getData();

        call.enqueue(new Callback<XLMModeli>() {
            @Override
            public void onResponse(Call<XLMModeli> call, Response<XLMModeli> response) {

                if(response.isSuccessful())
                {

                    acilisText.setText(response.body().acilis);
                    anlikDegerText.setText(response.body().anlik);
                    tahminText.setText(response.body().tahmin);
                    coinLogosu.setBackgroundResource(R.drawable.xlmcoin);
                    loading_dialogObj.dismissDialog();

                }

            }

            @Override
            public void onFailure(Call<XLMModeli> call, Throwable t) {
                System.out.println(t.getLocalizedMessage().toString());
            }


        });

    }

    private void getPriceBATUSDT()
    {
        BATApi kriptoApi = retrofit.create(BATApi.class);

        Call<BATModeli> call = kriptoApi.getData();

        call.enqueue(new Callback<BATModeli>() {
            @Override
            public void onResponse(Call<BATModeli> call, Response<BATModeli> response) {

                if(response.isSuccessful())
                {

                    acilisText.setText(response.body().acilis);
                    anlikDegerText.setText(response.body().anlik);
                    tahminText.setText(response.body().tahmin);
                    coinLogosu.setBackgroundResource(R.drawable.batcoin);
                    loading_dialogObj.dismissDialog();

                }

            }

            @Override
            public void onFailure(Call<BATModeli> call, Throwable t) {
                System.out.println(t.getLocalizedMessage().toString());
            }


        });

    }

    private void getPriceLINKUSDT()
    {
        LINKApi kriptoApi = retrofit.create(LINKApi.class);

        Call<LINKModeli> call = kriptoApi.getData();

        call.enqueue(new Callback<LINKModeli>() {
            @Override
            public void onResponse(Call<LINKModeli> call, Response<LINKModeli> response) {

                if(response.isSuccessful())
                {

                    acilisText.setText(response.body().acilis);
                    anlikDegerText.setText(response.body().anlik);
                    tahminText.setText(response.body().tahmin);
                    coinLogosu.setBackgroundResource(R.drawable.linkcoin);
                    loading_dialogObj.dismissDialog();

                }

            }

            @Override
            public void onFailure(Call<LINKModeli> call, Throwable t) {
                System.out.println(t.getLocalizedMessage().toString());
            }


        });

    }

    private void getPriceBANDUSDT()
    {
        BANDApi kriptoApi = retrofit.create(BANDApi.class);

        Call<BANDModeli> call = kriptoApi.getData();

        call.enqueue(new Callback<BANDModeli>() {
            @Override
            public void onResponse(Call<BANDModeli> call, Response<BANDModeli> response) {

                if(response.isSuccessful())
                {

                    acilisText.setText(response.body().acilis);
                    anlikDegerText.setText(response.body().anlik);
                    tahminText.setText(response.body().tahmin);
                    coinLogosu.setBackgroundResource(R.drawable.bandcoin);
                    loading_dialogObj.dismissDialog();

                }

            }

            @Override
            public void onFailure(Call<BANDModeli> call, Throwable t) {
                System.out.println(t.getLocalizedMessage().toString());
            }


        });

    }

    private void getPriceONTUSDT()
    {
        ONTApi kriptoApi = retrofit.create(ONTApi.class);

        Call<ONTModeli> call = kriptoApi.getData();

        call.enqueue(new Callback<ONTModeli>() {
            @Override
            public void onResponse(Call<ONTModeli> call, Response<ONTModeli> response) {

                if(response.isSuccessful())
                {

                    acilisText.setText(response.body().acilis);
                    anlikDegerText.setText(response.body().anlik);
                    tahminText.setText(response.body().tahmin);
                    coinLogosu.setBackgroundResource(R.drawable.ontcoin);
                    loading_dialogObj.dismissDialog();

                }

            }

            @Override
            public void onFailure(Call<ONTModeli> call, Throwable t) {
                System.out.println(t.getLocalizedMessage().toString());
            }


        });

    }

    private void getPriceIOTAUSDT()
    {
        IOTAApi kriptoApi = retrofit.create(IOTAApi.class);

        Call<IOTAModeli> call = kriptoApi.getData();

        call.enqueue(new Callback<IOTAModeli>() {
            @Override
            public void onResponse(Call<IOTAModeli> call, Response<IOTAModeli> response) {

                if(response.isSuccessful())
                {

                    acilisText.setText(response.body().acilis);
                    anlikDegerText.setText(response.body().anlik);
                    tahminText.setText(response.body().tahmin);
                    coinLogosu.setBackgroundResource(R.drawable.iota);
                    loading_dialogObj.dismissDialog();

                }

            }

            @Override
            public void onFailure(Call<IOTAModeli> call, Throwable t) {
                System.out.println(t.getLocalizedMessage().toString());
            }


        });

    }
}