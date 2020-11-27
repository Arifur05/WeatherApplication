package com.arifur.weatherapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arifur.weatherapplication.Models.HistoricalData.Current;
import com.arifur.weatherapplication.Models.HistoricalData.HistoricalWeatherData;
import com.arifur.weatherapplication.R;

import java.util.HashMap;
import java.util.List;

/**
 * @author : Arif
 * @date : 27-November-2020 07:01 PM
 * @package : com.arifur.weatherapplication.Adapters
 * -------------------------------------------
 * Copyright (C) 2020 - All Rights Reserved
 **/

public class HistoricalDataAdapter extends RecyclerView.Adapter<HistoricalDataAdapter.HistoricalDataViewModel> {
    Context mContext;
    List<Integer> historicDataList, tempList , feelsList;

    public HistoricalDataAdapter(Context context, List<Integer> historicDataList, List<Integer> tempList, List<Integer> feelsList) {
        mContext = context;
        this.historicDataList = historicDataList;
        this.tempList = tempList;
        this.feelsList = feelsList;
    }


    @NonNull
    @Override
    public HistoricalDataViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mContext);
        View view=inflater.inflate(R.layout.daily_forcast_card, parent, false);

        return new HistoricalDataViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoricalDataViewModel holder, int position) {
        if (historicDataList!=null){
            Integer epoch= historicDataList.get(position);
            String date = new java.text.SimpleDateFormat("E, dd MMM")
                    .format(new java.util.Date (epoch*1000L));
            holder.mDate.setText(date);
            long temp= Math.round(tempList.get(position));
            holder.mMaxTemp.setText(String.valueOf(temp) +" °C");
            long mintemp= Math.round(feelsList.get(position));
            holder.mMinTemp.setText(String.valueOf(mintemp) +" °C");

        }
    }

    @Override
    public int getItemCount() {
        return historicDataList.size();
    }


    public class HistoricalDataViewModel extends RecyclerView.ViewHolder {

        TextView mDate, mMaxTemp, mMinTemp;

        public HistoricalDataViewModel(@NonNull View itemView) {
            super(itemView);

            mDate= itemView.findViewById(R.id.day);
            mMaxTemp= itemView.findViewById(R.id.maxtemp);
            mMinTemp= itemView.findViewById(R.id.mintemp);
        }
    }

}
