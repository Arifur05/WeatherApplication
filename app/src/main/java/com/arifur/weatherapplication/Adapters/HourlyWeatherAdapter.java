package com.arifur.weatherapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arifur.weatherapplication.Models.Hourly;
import com.arifur.weatherapplication.R;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * @author : Arif
 * @date : 26-November-2020 09:39 PM
 * @package : com.arifur.weatherapplication.Adapters
 * -------------------------------------------
 * Copyright (C) 2020 - All Rights Reserved
 **/
public class HourlyWeatherAdapter extends RecyclerView.Adapter<HourlyWeatherAdapter.HourlyWeatherViewModel> {
    Context mContext;
    List<Hourly> mHourlyList;

    public HourlyWeatherAdapter(Context context, List<Hourly> hourlyList) {
        mContext = context;
        mHourlyList = hourlyList;
    }

    @NonNull
    @Override
    public HourlyWeatherViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mContext);
        View view=inflater.inflate(R.layout.hourly_weather_card, parent, false);

        return new HourlyWeatherViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HourlyWeatherViewModel holder, int position) {

        if (null != mHourlyList){
            Integer time=mHourlyList.get(position).getDt();
            String date = new java.text.SimpleDateFormat("HH:mm a").format(new java.util.Date (time*1000L));
            holder.mTime.setText(date);
            long temp= Math.round(mHourlyList.get(position).getTemp());
            holder.mTemperature.setText(String.valueOf(temp) +" °C");
        }
        else {
            holder.mTime.setText(R.string.time_String);
            holder.mTemperature.setText(R.string.temperature);
        }

    }

    @Override
    public int getItemCount() {
        return mHourlyList.size();
    }


    public class HourlyWeatherViewModel extends RecyclerView.ViewHolder {

        TextView mTime, mTemperature;

        public HourlyWeatherViewModel(@NonNull View itemView) {
            super(itemView);

            mTime= itemView.findViewById(R.id.currentTime);
            mTemperature= itemView.findViewById(R.id.hour_forcast_temp);
        }
    }

}
