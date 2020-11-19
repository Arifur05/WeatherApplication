package com.arifur.weatherapplication.Utils;

import com.arifur.weatherapplication.Utils.Constants;
import com.arifur.weatherapplication.WeatherApi.WeatherApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.arifur.weatherapplication.Utils.Constants.BASE_URL_OPEN_WEATHER;
import static com.arifur.weatherapplication.Utils.Constants.CONNECTION_TIMEOUT;
import static com.arifur.weatherapplication.Utils.Constants.READ_TIMEOUT;
import static com.arifur.weatherapplication.Utils.Constants.WRITE_TIMEOUT;

/**
 * @author : Arif
 * @date : 18-November-2020 09:47 PM
 * @package : com.arifur.weatherapplication
 * -------------------------------------------
 * Copyright (C) 2020 - All Rights Reserved
 **/
public class Requests {
    private static OkHttpClient client = new OkHttpClient.Builder()

            // establish connection to server
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)

            // time between each byte read from the server
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)

            // time between each byte sent to server
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)

            .retryOnConnectionFailure(false)

            .build();


    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL_OPEN_WEATHER)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create());
    private static Retrofit.Builder retrofitBuilder1 =
            new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL_WEATHERBIT)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static Retrofit retrofit1 = retrofitBuilder1.build();

    private static WeatherApi sWeatherApi = retrofit.create(WeatherApi.class);
    private static WeatherApi sWeatherApi1 = retrofit1.create(WeatherApi.class);

    public static WeatherApi getWeatherApiWeatherBit(){
        return sWeatherApi1;
    }
    public static WeatherApi getWeatherApi(){
        return sWeatherApi;
    }
}
