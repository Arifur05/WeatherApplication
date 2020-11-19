package com.arifur.weatherapplication.Models.DailyWeather;

/**
 * @author : Arif
 * @date : 19-November-2020 02:11 AM
 * @package : com.arifur.weatherapplication.Models
 * -------------------------------------------
 * Copyright (C) 2020 - All Rights Reserved
 **/
public class HourCardDataModel {
    String timeview, tempview;

    public HourCardDataModel(String timeview, String tempview) {
        this.timeview = timeview;
        this.tempview = tempview;
    }

    public String getTimeview() {
        return timeview;
    }

    public void setTimeview(String timeview) {
        this.timeview = timeview;
    }

    public String getTempview() {
        return tempview;
    }

    public void setTempview(String tempview) {
        this.tempview = tempview;
    }
}
