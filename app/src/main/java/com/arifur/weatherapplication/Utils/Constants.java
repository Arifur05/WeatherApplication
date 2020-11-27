package com.arifur.weatherapplication.Utils;

/**
 * @author : Arif
 * @date : 26-November-2020 06:55 PM
 * @package : com.arifur.weatherapplication.Utils
 * -------------------------------------------
 * Copyright (C) 2020 - All Rights Reserved
 **/
public class Constants {

    public static final String OPEN_WEATHER_URL = "https://api.openweathermap.org/data/2.5/";
    public static final String OPEN_WEATHER_API_KEY = "a32eee28f81f845780d66f373776bbe5";


    public static final int CONNECTION_TIMEOUT = 120; // 30 seconds
    public static final int READ_TIMEOUT = 5; // 5 seconds
    public static final int WRITE_TIMEOUT = 5; // 5 seconds

    public static final int WEATHER_REFRESH_TIME = 60 * 30; // 30 min (in seconds)

}
