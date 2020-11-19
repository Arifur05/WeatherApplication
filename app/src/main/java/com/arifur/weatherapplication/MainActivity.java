package com.arifur.weatherapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arifur.weatherapplication.Adapter.DailyTempAdapter;
import com.arifur.weatherapplication.Adapter.HourTempAdapter;
import com.arifur.weatherapplication.Models.CurrentWeather;
import com.arifur.weatherapplication.Models.Daily;
import com.arifur.weatherapplication.Models.Daily7DaysWeather;
import com.arifur.weatherapplication.Models.Hourly;
import com.arifur.weatherapplication.Models.HourlyWeather;
import com.arifur.weatherapplication.Models.Main;
import com.arifur.weatherapplication.Utils.Requests;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.arifur.weatherapplication.Utils.Constants.OPEN_WEATHER_API_KEY;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner mLocationSpinner;
    TextView mTodaysTemperature, mRealFeel;
    String[] location_names = {"Dhaka", "Chittagong", "Sylhet", "Barisal", "Khulna", "Rajshahi"};
    String[] location_code = {"28143", "27822", "30917", "27110", "29075", "30529"};
    String cityKey, city;
    ProgressBar mProgressBar;
    RecyclerView mHourlyTemprv, mDailyTemprv;
    private HourTempAdapter mHourTempAdapter;
    private DailyTempAdapter mDailyTempAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTodaysTemperature = findViewById(R.id.todaysTemperature);
        mLocationSpinner = findViewById(R.id.location);
        mRealFeel = findViewById(R.id.realFeel);
        mLocationSpinner.setOnItemSelectedListener(MainActivity.this);
        mProgressBar = findViewById(R.id.progress_circular);
        mHourlyTemprv = findViewById(R.id.hourlytemperature);
        mDailyTemprv= findViewById(R.id.dailytemperature);
        mHourlyTemprv.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
        mDailyTemprv.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, location_names);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mLocationSpinner.setAdapter(arrayAdapter);
        getCurrentWeatherData();
        getHourlyWeatherData();
        getDailyWeatherData();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        //Toast.makeText(getApplicationContext(), location_names[position], Toast.LENGTH_LONG).show();
        cityKey = "28143";
        city = location_names[position];

        //Toast.makeText(this, cityKey, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

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
                    Main main = currentWeatherList.getMain();
                    long feels = Math.round(main.getFeelsLike());
                    mTodaysTemperature.setText(main.getTemp().toString() + "°C");
                    mRealFeel.setText("feels like " + feels + "°C");
                    mProgressBar.setVisibility(View.GONE);

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
        Call<Daily7DaysWeather> hourlyWeatherCall = Requests.getWeatherApi().getHourlyWeather(OPEN_WEATHER_API_KEY);
        hourlyWeatherCall.enqueue(new Callback<Daily7DaysWeather>() {
            @Override
            public void onResponse(Call<Daily7DaysWeather> call, Response<Daily7DaysWeather> response) {
                if (response.isSuccessful()) {
                    Daily7DaysWeather daily7DaysWeather = response.body();
                    List<Hourly> hourlyList= daily7DaysWeather.getHourly();
                    List<Daily> dailyList= daily7DaysWeather.getDaily();

                    mHourTempAdapter=new HourTempAdapter(getApplicationContext(),hourlyList);
                    //mDailyTempAdapter = new DailyTempAdapter(getApplicationContext(),dailyList);
                    mHourlyTemprv.setAdapter(mHourTempAdapter);
                    //mDailyTemprv.setAdapter(mDailyTempAdapter);

                }
            }

            @Override
            public void onFailure(Call<Daily7DaysWeather> call, Throwable t) {

            }
        });
    }

    //Hourly and Daily Weather Data
    public void getDailyWeatherData() {
        Call<Daily7DaysWeather> hourlyWeatherCall = Requests.getWeatherApi().getHourlyWeather(OPEN_WEATHER_API_KEY);
        hourlyWeatherCall.enqueue(new Callback<Daily7DaysWeather>() {
            @Override
            public void onResponse(Call<Daily7DaysWeather> call, Response<Daily7DaysWeather> response) {
                if (response.isSuccessful()) {
                    Daily7DaysWeather daily7DaysWeather = response.body();
                    List<Daily> dailyList= daily7DaysWeather.getDaily();

                    mDailyTempAdapter = new DailyTempAdapter(getApplicationContext(),dailyList);
                    mDailyTemprv.setAdapter(mDailyTempAdapter);

                }
            }

            @Override
            public void onFailure(Call<Daily7DaysWeather> call, Throwable t) {

            }
        });
    }
}