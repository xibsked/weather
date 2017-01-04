package com.sked.weather.data.remote;

import com.sked.weather.data.Forecast;
import com.sked.weather.data.PlaceInfo;
import com.sked.weather.data.RSS;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Weather, All rights Reserved
 * Created by Sanjeet on 01-Jan-17.
 */

public interface WeatherService {

    @GET
    Call<RSS> news(@Url String url);

    @GET("/data/2.5/weather")
    Call<PlaceInfo> placeInfo(@Query("q") String query, @Query("appid") String appId);


    @GET("/data/2.5/forecast")
    Call<Forecast> getForecasts(@Query("q") String query, @Query("appid") String appId);
}
