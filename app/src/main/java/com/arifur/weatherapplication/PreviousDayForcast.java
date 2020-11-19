package com.arifur.weatherapplication;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arifur.weatherapplication.Adapter.HistoricalDataAdapter;
import com.arifur.weatherapplication.Models.HistoricalData.Datum;
import com.arifur.weatherapplication.Models.HistoricalData.HistoricalWeatherData;
import com.arifur.weatherapplication.Utils.Requests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.arifur.weatherapplication.Utils.Constants.WEATHERBIT_API_KEY;

public class PreviousDayForcast extends AppCompatActivity {
    ProgressBar mProgressBar;
    RecyclerView mPreviousrv;
    HistoricalDataAdapter mHistoricalDataAdapter;
    Call<HistoricalWeatherData> historicalWeatherDataCall;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_day_forcast);
        mPreviousrv = findViewById(R.id.previousdays);
        mProgressBar = findViewById(R.id.progress_circular);
        mPreviousrv.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        mPreviousrv.setHasFixedSize(true);
        getPreviousData();
    }

    public void getPreviousData() {
        mProgressBar.setVisibility(View.VISIBLE);

           historicalWeatherDataCall= Requests.getWeatherApiWeatherBit().getHistoryData("2020-11-18","2020-11-19",WEATHERBIT_API_KEY);

            historicalWeatherDataCall.enqueue(new Callback<HistoricalWeatherData>() {
                @Override
                public void onResponse(Call<HistoricalWeatherData> call, Response<HistoricalWeatherData> response) {
                    if (response.isSuccessful()){
                        HistoricalWeatherData historicalWeatherData= response.body();
                        List<Datum> datumList= historicalWeatherData.getData();
                        mHistoricalDataAdapter= new HistoricalDataAdapter(getApplicationContext(),datumList);
                        mPreviousrv.setAdapter(mHistoricalDataAdapter);

                    }
                    mProgressBar.setVisibility(View.GONE);
                }

                @Override
                public void onFailure(Call<HistoricalWeatherData> call, Throwable t) {

                }
            });



    }
}