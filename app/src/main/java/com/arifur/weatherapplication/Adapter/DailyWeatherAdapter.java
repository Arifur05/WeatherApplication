package com.arifur.weatherapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arifur.weatherapplication.Models.DailyWeather.Daily;
import com.arifur.weatherapplication.R;

import java.util.List;

/**
 * @author : Arif
 * @date : 19-November-2020 07:20 PM
 * @package : com.arifur.weatherapplication.Adapter
 * -------------------------------------------
 * Copyright (C) 2020 - All Rights Reserved
 **/
public class DailyWeatherAdapter extends RecyclerView.Adapter<DailyWeatherAdapter.DailyWeatherViewHolder> {
    Context mContext;
    List<Daily> mDailyList;

    public DailyWeatherAdapter(Context context, List<Daily> dailyList) {
        mContext = context;
        mDailyList = dailyList;
    }

    @NonNull
    @Override
    public DailyWeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mContext);
        View view=inflater.inflate(R.layout.daily_forcast_card, parent, false);

        return new DailyWeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyWeatherViewHolder holder, int position) {
        holder.mDate.setText(mDailyList.get(position).getDt().toString());
        holder.mMaxTemp.setText(mDailyList.get(position).getTemp().getMax().toString());
        holder.mMinTemp.setText(mDailyList.get(position).getTemp().getMin().toString());
    }

    @Override
    public int getItemCount() {
        return mDailyList.size();
    }

    public static class DailyWeatherViewHolder extends RecyclerView.ViewHolder{
        TextView mDate, mMinTemp, mMaxTemp;
        public DailyWeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            mDate= itemView.findViewById(R.id.day);
            mMaxTemp= itemView.findViewById(R.id.maxtemp);
            mMinTemp= itemView.findViewById(R.id.mintemp);

        }
    }
}
