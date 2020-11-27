package com.arifur.weatherapplication.Utils;


import com.arifur.weatherapplication.Api.WeatherApis;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.arifur.weatherapplication.Utils.Constants.CONNECTION_TIMEOUT;
import static com.arifur.weatherapplication.Utils.Constants.OPEN_WEATHER_URL;
import static com.arifur.weatherapplication.Utils.Constants.READ_TIMEOUT;
import static com.arifur.weatherapplication.Utils.Constants.WRITE_TIMEOUT;

/**
 * @author : Arif
 * @date : 26-November-2020 07:16 PM
 * @package : com.arifur.weatherapplication.Utils
 * -------------------------------------------
 * Copyright (C) 2020 - All Rights Reserved
 **/
public class Requests {

    private static OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .retryOnConnectionFailure(false)
            .build();

    private static Retrofit.Builder retrofitBuilder  =
            new Retrofit.Builder()
                    .baseUrl(Constants.OPEN_WEATHER_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();
    private static WeatherApis sWeatherApi = retrofit.create(WeatherApis.class);

    public static WeatherApis getOpenWeatherApi(){
        return sWeatherApi;
    }
}
