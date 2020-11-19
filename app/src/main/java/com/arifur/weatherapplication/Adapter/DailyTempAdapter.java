package com.arifur.weatherapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arifur.weatherapplication.Models.Daily;
import com.arifur.weatherapplication.R;

import java.util.List;

/**
 * @author : Arif
 * @date : 19-November-2020 03:37 PM
 * @package : com.arifur.weatherapplication.Adapter
 * -------------------------------------------
 * Copyright (C) 2020 - All Rights Reserved
 **/
public class DailyTempAdapter extends RecyclerView.Adapter<DailyTempAdapter.DailyTempHolder>{

    Context mContext;
    List<Daily> mDailyList;
    Integer time;
    public DailyTempAdapter(Context context, List<Daily> dailyList) {
        mContext = context;
        mDailyList = dailyList;
    }

    @NonNull
    @Override
    public DailyTempHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mContext);
        View view=inflater.inflate(R.layout.daily_forcast_card, parent, false);

        return new DailyTempHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyTempHolder holder, int position) {
        if (mDailyList != null) {
            time = mDailyList.get(position).getDt();
            String date = new java.text.SimpleDateFormat("dd/MM/yyyy ").format(new java.util.Date(time * 1000L));
            holder.mDate.setText(date);
            holder.mMaxTemp.setText(mDailyList.get(position).getTemp().getMax().toString());
            holder.mMinTemp.setText(mDailyList.get(position).getTemp().getMin().toString());
        }
    }

    @Override
    public int getItemCount() {
        return mDailyList.size();
    }

    public static class DailyTempHolder extends RecyclerView.ViewHolder{
        TextView mDate, mMinTemp, mMaxTemp;

        public DailyTempHolder(@NonNull View itemView) {
            super(itemView);
            mDate= itemView.findViewById(R.id.day);
            mMaxTemp= itemView.findViewById(R.id.maxtemp);
            mMinTemp= itemView.findViewById(R.id.mintemp);
        }
    }
}
