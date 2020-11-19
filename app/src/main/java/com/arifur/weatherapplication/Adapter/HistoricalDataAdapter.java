package com.arifur.weatherapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arifur.weatherapplication.Models.HistoricalData.Datum;
import com.arifur.weatherapplication.R;

import java.util.List;

/**
 * @author : Arif
 * @date : 19-November-2020 10:11 PM
 * @package : com.arifur.weatherapplication.Adapter
 * -------------------------------------------
 * Copyright (C) 2020 - All Rights Reserved
 **/
public class HistoricalDataAdapter extends RecyclerView.Adapter<HistoricalDataAdapter.HistoricalDataViewHolder>{

    Context mContext;
    List<Datum> mDatumList;

    public HistoricalDataAdapter(Context context, List<Datum> datumList) {
        mContext = context;
        mDatumList = datumList;
    }

    @NonNull
    @Override
    public HistoricalDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mContext);
        View view=inflater.inflate(R.layout.daily_forcast_card, parent, false);

        return new HistoricalDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoricalDataViewHolder holder, int position) {
        holder.mDate.setText(mDatumList.get(position).getDatetime());
        holder.mMax.setText(mDatumList.get(position).getMaxTemp().toString());
        holder.mMin.setText(mDatumList.get(position).getMinTemp().toString());
    }

    @Override
    public int getItemCount() {
        return mDatumList.size();
    }

    public static class HistoricalDataViewHolder extends RecyclerView.ViewHolder{
        TextView mDate,mMin,mMax;
        public HistoricalDataViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
