package com.arifur.weatherapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arifur.weatherapplication.Adapter.DailyWeatherAdapter;
import com.arifur.weatherapplication.Adapter.HourTempAdapter;

import com.arifur.weatherapplication.Models.CurrentWeather.CurrentWeather;
import com.arifur.weatherapplication.Models.CurrentWeather.Main;
import com.arifur.weatherapplication.Models.DailyWeather.Daily;
import com.arifur.weatherapplication.Models.DailyWeather.DailyWeather;
import com.arifur.weatherapplication.Models.HourlyWeather.Hourly;
import com.arifur.weatherapplication.Models.HourlyWeather.HourlyWeather;
import com.arifur.weatherapplication.Utils.Requests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.arifur.weatherapplication.Utils.Constants.OPEN_WEATHER_API_KEY;

public class MainActivity extends AppCompatActivity {

    TextView mTodaysTemperature, mRealFeel, sunrise, sunset;

    ProgressBar mProgressBar;
    RecyclerView mHourlyTemprv, mDailyTemprv;
    private HourTempAdapter mHourTempAdapter;
    private DailyWeatherAdapter mDailyTempAdapter;
    Button mPrevForcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTodaysTemperature = findViewById(R.id.todaysTemperature);
        sunrise= findViewById(R.id.sunrise);
        sunset= findViewById(R.id.sunset);
        mRealFeel = findViewById(R.id.realFeel);
        mPrevForcast= findViewById(R.id.previous);
        mProgressBar = findViewById(R.id.progress_circular);
        mHourlyTemprv = findViewById(R.id.hourlytemperature);
        mDailyTemprv= findViewById(R.id.dailytemperaturerv);
        mHourlyTemprv.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
        mDailyTemprv.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL,false));

        mPrevForcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, PreviousDayForcast.class);
                startActivity(intent);
            }
        });


        getCurrentWeatherData();
        getHourlyWeatherData();
        getDailyWeatherData();
    }



    //current Weather Data
    public void getCurrentWeatherData() {

        mProgressBar.setVisibility(View.VISIBLE);
        Call<CurrentWeather> currentWeatherCall = Requests.getWeatherApi().getCurrentWeather(OPEN_WEATHER_API_KEY, "Dhaka");
        currentWeatherCall.enqueue(new Callback<CurrentWeather>() {
            @Override
            public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                if (response.isSuccessful()) {
                    CurrentWeather currentWeatherList = response.body();
                    Log.d("MAIN ACTIVITY", currentWeatherList.toString());
                    Main main = currentWeatherList.getMain();
                    long feels = Math.round(main.getFeelsLike());
                    mTodaysTemperature.setText(main.getTemp().toString() + "°C");
                    mRealFeel.setText("feels like " + feels + "°C");
                    mProgressBar.setVisibility(View.GONE);
                    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                    sunrise.setText("Sunrrises at:" +dateFormat.format(currentWeatherList.getSys().getSunrise()));
                    sunset.setText("Sunrsets at:" +dateFormat.format(currentWeatherList.getSys().getSunset()));
                } else {
                    Toast.makeText(MainActivity.this, "Unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CurrentWeather> call, Throwable t) {

            }
        });

    }

    //Hourly and Daily Weather Data
    public void getHourlyWeatherData() {
        mProgressBar.setVisibility(View.VISIBLE);
        Call<HourlyWeather> hourlyWeatherCall = Requests.getWeatherApi().getHourlyWeather(OPEN_WEATHER_API_KEY);
        hourlyWeatherCall.enqueue(new Callback<HourlyWeather>() {
            @Override
            public void onResponse(Call<HourlyWeather> call, Response<HourlyWeather> response) {
                if (response.isSuccessful()) {
                    HourlyWeather hourlyWeather = response.body();
                    List<Hourly> hourlyList= hourlyWeather.getHourly();
                    Log.d("MAIN", hourlyList.toString());

                    mHourTempAdapter=new HourTempAdapter(getApplicationContext(),hourlyList);

                    mHourlyTemprv.setAdapter(mHourTempAdapter);

                    mProgressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<HourlyWeather> call, Throwable t) {

            }
        });
    }

    //Hourly and Daily Weather Data
    public void getDailyWeatherData() {
        mProgressBar.setVisibility(View.VISIBLE);
        Call<DailyWeather> hourlyWeatherCall = Requests.getWeatherApi().getDailyWeather(OPEN_WEATHER_API_KEY);
        hourlyWeatherCall.enqueue(new Callback<DailyWeather>() {
            @Override
            public void onResponse(Call<DailyWeather> call, Response<DailyWeather> response) {
                if (response.isSuccessful()) {
                    DailyWeather dailyWeather = response.body();
                    List<Daily> dailyList= dailyWeather.getDaily();

                    Log.d("MAIN ACTIVITY", dailyList.toString());

                    mDailyTempAdapter = new DailyWeatherAdapter(getApplicationContext(),dailyList);
                    mDailyTemprv.setAdapter(mDailyTempAdapter);
                    mProgressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<DailyWeather> call, Throwable t) {

            }
        });
    }
}