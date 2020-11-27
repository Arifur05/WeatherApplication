package com.arifur.weatherapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arifur.weatherapplication.Adapters.DailyForcastAdapter;
import com.arifur.weatherapplication.Adapters.HourlyWeatherAdapter;
import com.arifur.weatherapplication.Models.Daily;
import com.arifur.weatherapplication.Models.Hourly;
import com.arifur.weatherapplication.Models.WeatherModel;
import com.arifur.weatherapplication.Utils.Constants;
import com.arifur.weatherapplication.Utils.Requests;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author : Arif
 * @date : 26-November-2020 07:10 PM
 * @package : com.arifur.weatherapplication.Api
 * -------------------------------------------
 * Copyright (C) 2020 - All Rights Reserved
 **/

public class MainActivity extends AppCompatActivity {

    TextView mLocation, mCurrentWeather, mFeelsLikeWeather, sunrise, sunset;
    RecyclerView mHourlyRV, mDailyRV;
    ProgressBar mLoadingBar;
    private HourlyWeatherAdapter mHourlyWeatherAdapter;
    private DailyForcastAdapter mDailyForcastAdapter;
    Button mHistoralWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoadingBar = findViewById(R.id.loading);
        mCurrentWeather = findViewById(R.id.currentTemp);
        mFeelsLikeWeather = findViewById(R.id.feelsliketemp);
        mLocation= findViewById(R.id.location);
        mHourlyRV = findViewById(R.id.hourlyforcast);
        mDailyRV = findViewById(R.id.daily_forcast);
        sunrise= findViewById(R.id.sunrise);
        sunset= findViewById(R.id.sunsets);
        mHourlyRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mDailyRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mHistoralWeather = findViewById(R.id.historical_forcast);

        mHistoralWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HistoricalDataActivity.class);
                startActivity(intent);
            }
        });
        getWeatherData();
    }

    public void getWeatherData() {
        mLoadingBar.setVisibility(View.VISIBLE);

        Call<WeatherModel> mWeatherModelCall = Requests.getOpenWeatherApi().getWeather(Constants.OPEN_WEATHER_API_KEY);
        mWeatherModelCall.enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {

                WeatherModel weatherModel = response.body();

                Integer epoch= weatherModel.getCurrent().getSunrise();
                String date = new java.text.SimpleDateFormat("HH:mm a").format(new java.util.Date (epoch*1000L));
                sunrise.setText("sun rises in " +date);
                Integer epochsunset= weatherModel.getCurrent().getSunrise();
                String datesunset = new java.text.SimpleDateFormat("HH:mm a").format(new java.util.Date (epochsunset*1000L));
                sunset.setText("sun sets in " +datesunset);
                mLocation.setText(weatherModel.getTimezone());
                mCurrentWeather.setText(weatherModel.getCurrent().getTemp().toString() + " °C");
                mFeelsLikeWeather.setText("Feels Like " + Math.round(weatherModel.getCurrent().getFeelsLike()) + " °C");
                List<Hourly> mHourly = weatherModel.getHourly();

                mHourlyWeatherAdapter = new HourlyWeatherAdapter(getApplicationContext(), mHourly);
                mHourlyRV.setAdapter(mHourlyWeatherAdapter);

                List<Daily> mDaily = weatherModel.getDaily();
                mDailyForcastAdapter = new DailyForcastAdapter(getApplicationContext(), mDaily);
                mDailyRV.setAdapter(mDailyForcastAdapter);
                Log.d("TAG", "Succeed");
                mLoadingBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {

                Log.d("TAG", t.getCause().toString());

            }
        });
    }


}