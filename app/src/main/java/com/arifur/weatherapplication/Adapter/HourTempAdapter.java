package com.arifur.weatherapplication.Adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.arifur.weatherapplication.Models.HourlyWeather.Hourly;
import com.arifur.weatherapplication.R;

import java.util.List;

/**
 * @author : Arif
 * @date : 19-November-2020 02:15 AM
 * @package : com.arifur.weatherapplication.ViewHolder
 * -------------------------------------------
 * Copyright (C) 2020 - All Rights Reserved
 **/
public class HourTempAdapter extends RecyclerView.Adapter<HourTempAdapter.HourTempViewHolder> {
    private Context mContext;
    private List<Hourly> mHourlyWeathersList;
    Integer time;
    public HourTempAdapter(Context context, List<Hourly> hourlyWeathersList) {
        mContext = context;
        mHourlyWeathersList = hourlyWeathersList;
    }


    @NonNull
    @Override
    public HourTempViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mContext);
        View view=inflater.inflate(R.layout.hour_temp, parent, false);

        return new HourTempViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull HourTempViewHolder holder, int position) {
        if (mHourlyWeathersList!=null){
            time=mHourlyWeathersList.get(position).getDt();
            String date = new java.text.SimpleDateFormat("HH:mm").format(new java.util.Date (time*1000L));
            holder.mTime.setText(date.toString());
            holder.mHourlyTemp.setText(mHourlyWeathersList.get(position).getTemp().toString());
        }
    }

    @Override
    public int getItemCount() {
        return mHourlyWeathersList.size();
    }

    public static class HourTempViewHolder extends RecyclerView.ViewHolder{
        TextView mTime, mHourlyTemp;
        public HourTempViewHolder(@NonNull View itemView) {
            super(itemView);
            mTime= itemView.findViewById(R.id.time);
            mHourlyTemp= itemView.findViewById(R.id.hourlytemp);

        }
    }


}
