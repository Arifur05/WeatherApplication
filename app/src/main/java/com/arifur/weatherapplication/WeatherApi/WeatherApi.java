package com.arifur.weatherapplication.WeatherApi;

import com.arifur.weatherapplication.Models.CurrentWeather;
import com.arifur.weatherapplication.Models.Daily7DaysWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author : Arif
 * @date : 18-November-2020 09:50 PM
 * @package : com.arifur.weatherapplication.WeatherApi
 * -------------------------------------------
 * Copyright (C) 2020 - All Rights Reserved
 **/
public interface WeatherApi {
    @GET("weather?&units=metric")
    Call<CurrentWeather> getCurrentWeather(@Query("appid") String appId, @Query("q") String query);

    @GET("onecall?lat=23.9536&lon=90.1495&exclude=minutely,daily&units=metric")
    Call<Daily7DaysWeather> getHourlyWeather(@Query("appid") String appId);

    @GET("onecall?lat=23.9536&lon=90.1495&exclude=minutely,hourly&units=metric")
    Call<Daily7DaysWeather> getDailyWeather(@Query("appid") String appId);
}
