package com.sked.weather.home.daily;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sked.weather.BaseFragment;
import com.sked.weather.R;
import com.sked.weather.data.Error;
import com.sked.weather.data.Forecast;
import com.sked.weather.data.PlaceInfo;
import com.sked.weather.data.remote.DataSource;
import com.sked.weather.data.remote.Repository;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DailyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DailyFragment extends BaseFragment implements DataSource.ForecastInfoCallback {

    @BindView(R.id.forecastView)
    RecyclerView recyclerView;
    private ForecastAdapter adapter;
    private List<PlaceInfo> placeInfos;

    public DailyFragment() {
    }

    public static DailyFragment newInstance() {
        DailyFragment fragment = new DailyFragment();
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
        placeInfos = new ArrayList<>();
        adapter = new ForecastAdapter(placeInfos);
        return bind(inflater.inflate(R.layout.fragment_daily, container, false));
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        Repository.getInstance().getForecastInfo(this);
    }

    @Override
    public void retry(Error.Code code) {
    }

    @Override
    public void onForecastInfoFetched(Forecast forecast) {
        placeInfos.clear();
        placeInfos.addAll(forecast.placeInfos());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onError(Error error) {

    }
}
