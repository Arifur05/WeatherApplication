package com.arifur.weatherapplication.Api;

import com.arifur.weatherapplication.Models.HistoricalData.HistoricalWeatherData;
import com.arifur.weatherapplication.Models.WeatherModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author : Arif
 * @date : 26-November-2020 07:10 PM
 * @package : com.arifur.weatherapplication.Api
 * -------------------------------------------
 * Copyright (C) 2020 - All Rights Reserved
 **/
public interface WeatherApis {

    @GET("onecall?lat=23.8103&lon=90.4125&exclude=minutely&units=metric")
    Call<WeatherModel> getWeather(@Query("appid") String appid);

    @GET("onecall/timemachine?lat=23.8103&lon=90.4125&units=metric")
    Call<HistoricalWeatherData> getHistorical7DaysWeather(@Query("dt") Long epochTime, @Query("appid") String appid);
}
