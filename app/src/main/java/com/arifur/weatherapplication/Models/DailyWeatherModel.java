package com.arifur.weatherapplication.Models;

/**
 * @author : Arif
 * @date : 19-November-2020 03:36 PM
 * @package : com.arifur.weatherapplication.Models
 * -------------------------------------------
 * Copyright (C) 2020 - All Rights Reserved
 **/
public class DailyWeatherModel {
    String date, mintemp, maxtemp;

    public DailyWeatherModel(String date, String mintemp, String maxtemp) {
        this.date = date;
        this.mintemp = mintemp;
        this.maxtemp = maxtemp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMintemp() {
        return mintemp;
    }

    public void setMintemp(String mintemp) {
        this.mintemp = mintemp;
    }

    public String getMaxtemp() {
        return maxtemp;
    }

    public void setMaxtemp(String maxtemp) {
        this.maxtemp = maxtemp;
    }
}
