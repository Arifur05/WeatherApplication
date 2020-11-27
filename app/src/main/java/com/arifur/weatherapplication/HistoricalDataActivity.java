package com.arifur.weatherapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arifur.weatherapplication.Adapters.HistoricalDataAdapter;
import com.arifur.weatherapplication.Models.HistoricalData.Current;
import com.arifur.weatherapplication.Models.HistoricalData.HistoricalWeatherData;
import com.arifur.weatherapplication.Utils.Requests;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.arifur.weatherapplication.Utils.Constants.OPEN_WEATHER_API_KEY;

/**
 * @author : Arif
 * @date : 26-November-2020 07:10 PM
 * @package : com.arifur.weatherapplication.Api
 * -------------------------------------------
 * Copyright (C) 2020 - All Rights Reserved
 **/

public class HistoricalDataActivity extends AppCompatActivity {

    RecyclerView mHistoricalRV;
    int i;
    List<Integer> historicDataList, tempList, feltLikeList;
    HistoricalDataAdapter mHistoricalDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historical_data);
        historicDataList = new ArrayList<>();
        tempList = new ArrayList<>();
        feltLikeList= new ArrayList<>();
        mHistoricalRV = findViewById(R.id.historical_forcast_rv);
        mHistoricalRV.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        getHIstoricalData();

    }

    public void getHIstoricalData() {

        for (i = 1; i < 8; i++) {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -i);

            SimpleDateFormat s = new SimpleDateFormat("yyyyMMdd");
            String result = s.format(new Date(cal.getTimeInMillis()));
            //int datetime= Integer.parseInt(result);
            long epoch = (System.currentTimeMillis() - i * (24) * 3600000) / 1000;

            Log.d("TAG", result);
            Log.d("TAG", String.valueOf(epoch));

            Call<HistoricalWeatherData> historicalWeatherDataCall = Requests.getOpenWeatherApi().getHistorical7DaysWeather(epoch, OPEN_WEATHER_API_KEY);
            historicalWeatherDataCall.enqueue(new Callback<HistoricalWeatherData>() {
                @Override
                public void onResponse(Call<HistoricalWeatherData> call, Response<HistoricalWeatherData> response) {
                    if (response.isSuccessful()) {
                        HistoricalWeatherData historicalWeatherData = response.body();
                        Current currentData = historicalWeatherData.getCurrent();
                        historicDataList.add(currentData.getDt());
                        tempList.add(currentData.getTemp());
                        feltLikeList.add(currentData.getFeelsLike().intValue());
                        Log.d("TAG", currentData.getTemp().toString());

                        mHistoricalDataAdapter = new HistoricalDataAdapter(getApplicationContext(), historicDataList, tempList, feltLikeList);
                        mHistoricalRV.setAdapter(mHistoricalDataAdapter);
                    }
                }

                @Override
                public void onFailure(Call<HistoricalWeatherData> call, Throwable t) {
                    Log.d("TAG", "Failed: ");
                }
            });



        }
    }

}