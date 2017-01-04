package com.sked.weather.data.remote;

import android.util.Log;

import com.sked.weather.data.Channel;
import com.sked.weather.data.Error;
import com.sked.weather.data.Forecast;
import com.sked.weather.data.PlaceInfo;

import java.util.List;

/**
 * Weather, All rights Reserved
 * Created by Sanjeet on 01-Jan-17.
 */

public interface DataSource {
    String TAG = "DataSource";

    interface BaseCallback {
        default void onError(Error error) {
            Log.d(TAG, "onError: " + error.message());
        }
    }

    interface NewsCallback extends BaseCallback {
        void onNewsFetched(List<Channel.Item> rssItems);
    }

    void news(NewsCallback newsCallback);

    interface PlaceInfoCallback extends BaseCallback {
        void onPlaceInfoFetched(PlaceInfo placeInfo);
    }

    void getPlaceInfo(PlaceInfoCallback placeInfoCallback);

    interface ForecastInfoCallback extends BaseCallback {
        void onForecastInfoFetched(Forecast forecast);
    }

    void getForecastInfo(ForecastInfoCallback forecastInfoCallback);
}
