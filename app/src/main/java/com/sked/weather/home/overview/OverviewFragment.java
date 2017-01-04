package com.sked.weather.home.overview;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sked.weather.BaseFragment;
import com.sked.weather.R;
import com.sked.weather.data.Error;
import com.sked.weather.data.PlaceInfo;
import com.sked.weather.data.remote.DataSource;
import com.sked.weather.data.remote.Repository;
import com.sked.weather.util.UiUtils;

import java.util.Date;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OverviewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OverviewFragment extends BaseFragment implements DataSource.PlaceInfoCallback {

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
    @BindView(R.id.sunrise)
    TextView sunrise;
    @BindView(R.id.sunset)
    TextView sunset;
    @BindView(R.id.icon)
    ImageView icon;

    public OverviewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    public static OverviewFragment newInstance() {
        OverviewFragment fragment = new OverviewFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return bind(inflater.inflate(R.layout.fragment_overview, container, false));
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Repository.getInstance().getPlaceInfo(this);
    }

    @Override
    public void retry(Error.Code code) {

    }

    @Override
    public void onPlaceInfoFetched(PlaceInfo placeInfo) {
        temperature.setText(getString(R.string.label_temperature, placeInfo.parameters().temperature() - 273.15));
        Glide.with(getActivity()).load(UiUtils.getIconUrl(placeInfo.weathers().get(0).icon())).into(icon);
        variation.setText(getString(R.string.label_temperature_variation,
                placeInfo.parameters().minimumTemperature() - 273.15,
                placeInfo.parameters().maximumTemperature() - 273.15));
        wind.setText(getString(R.string.label_wind_value, placeInfo.wind().speed(), placeInfo.wind().angle()));
        cloud.setText(getString(R.string.label_cloudness_value, placeInfo.cloud().all() + ""));
        pressure.setText(getString(R.string.label_pressure_value, placeInfo.parameters().pressure()));
        humidity.setText(getString(R.string.label_humidity_value, placeInfo.parameters().humidity()));
        sunrise.setText(new Date(placeInfo.system().sunriseTime()*1000).toString());
        sunset.setText(new Date(placeInfo.system().sunsetTime()*1000).toString());
    }

    @Override
    public void onError(Error error) {
    }
}
