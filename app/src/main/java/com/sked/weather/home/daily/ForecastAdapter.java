package com.sked.weather.home.daily;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sked.weather.R;
import com.sked.weather.data.PlaceInfo;
import com.sked.weather.util.UiUtils;

import java.util.Date;
import java.util.List;

import butterknife.BindView;

import static butterknife.ButterKnife.bind;

/**
 * Weather, All rights Reserved
 * Created by Sanjeet on 01-Jan-17.
 */

public class ForecastAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<PlaceInfo> placeInfos;

    public ForecastAdapter(List<PlaceInfo> placeInfos) {
        this.placeInfos = placeInfos;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PlaceInfoItem(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_forecast, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PlaceInfo placeInfo = placeInfos.get(position);
        PlaceInfoItem holderItem = (PlaceInfoItem) holder;
        Context context = holder.itemView.getContext();
        holderItem.temperature.setText(context.getString(R.string.label_temperature, placeInfo.parameters().temperature() - 273.15));
        Glide.with(context).load(UiUtils.getIconUrl(placeInfo.weathers().get(0).icon())).into(holderItem.icon);
        holderItem.variation.setText(context.getString(R.string.label_temperature_variation,
                placeInfo.parameters().minimumTemperature() - 273.15,
                placeInfo.parameters().maximumTemperature() - 273.15));
        holderItem.wind.setText(context.getString(R.string.label_wind_value, placeInfo.wind().speed(), placeInfo.wind().angle()));
        holderItem.cloud.setText(context.getString(R.string.label_cloudness_value, placeInfo.cloud().all() + ""));
        holderItem.pressure.setText(context.getString(R.string.label_pressure_value, placeInfo.parameters().pressure()));
        holderItem.humidity.setText(context.getString(R.string.label_humidity_value, placeInfo.parameters().humidity()));
        holderItem.time.setText(new Date(placeInfo.time() * 1000).toString());
    }

    @Override
    public int getItemCount() {
        return placeInfos.size();
    }

    class PlaceInfoItem extends RecyclerView.ViewHolder {
        @BindView(R.id.temperature)
        TextView temperature;
        @BindView(R.id.minmax)
        TextView variation;
        @BindView(R.id.wind)
        TextView wind;
        @BindView(R.id.cloud)
        TextView cloud;
        @BindView(R.id.pressure)
        TextView pressure;
        @BindView(R.id.humidity)
        TextView humidity;
        @BindView(R.id.time)
        TextView time;
        @BindView(R.id.icon)
        ImageView icon;

        PlaceInfoItem(View itemView) {
            super(itemView);
            bind(this, itemView);
        }
    }
}
