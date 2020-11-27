package com.arifur.weatherapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arifur.weatherapplication.Models.Daily;
import com.arifur.weatherapplication.Models.Hourly;
import com.arifur.weatherapplication.R;

import java.util.List;

/**
 * @author : Arif
 * @date : 27-November-2020 12:37 AM
 * @package : com.arifur.weatherapplication.Adapters
 * -------------------------------------------
 * Copyright (C) 2020 - All Rights Reserved
 **/
public class DailyForcastAdapter extends RecyclerView.Adapter<DailyForcastAdapter.DailyForcastViewModel> {
    Context mContext;
    List<Daily> mDailyList;

    public DailyForcastAdapter(Context context, List<Daily> dailyList) {
        mContext = context;
        mDailyList = dailyList;
    }

    @NonNull
    @Override
    public DailyForcastViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mContext);
        View view=inflater.inflate(R.layout.daily_forcast_card, parent, false);

        return new DailyForcastViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyForcastViewModel holder, int position) {
        if (mDailyList!=null){
            Integer epoch= mDailyList.get(position).getDt();
            String date = new java.text.SimpleDateFormat("E, dd MMM")
                    .format(new java.util.Date (epoch*1000L));
            holder.mDate.setText(date);
            long temp= Math.round(mDailyList.get(position).getTemp().getMax());
            holder.mMaxTemp.setText(String.valueOf(temp) +" °C");
            long mintemp= Math.round(mDailyList.get(position).getTemp().getMin());
            holder.mMinTemp.setText(String.valueOf(mintemp) +" °C");

        }
    }

    @Override
    public int getItemCount() {
        return mDailyList.size();
    }


    public class DailyForcastViewModel extends RecyclerView.ViewHolder {

        TextView mDate, mMaxTemp, mMinTemp;

        public DailyForcastViewModel(@NonNull View itemView) {
            super(itemView);

            mDate= itemView.findViewById(R.id.day);
            mMaxTemp= itemView.findViewById(R.id.maxtemp);
            mMinTemp= itemView.findViewById(R.id.mintemp);
        }
    }

}
