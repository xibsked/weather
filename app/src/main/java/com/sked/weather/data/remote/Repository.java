package com.sked.weather.data.remote;

import com.sked.weather.data.Error;
import com.sked.weather.data.Forecast;
import com.sked.weather.data.PlaceInfo;
import com.sked.weather.data.RSS;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Weather, All rights Reserved
 * Created by Sanjeet on 01-Jan-17.
 */

public class Repository implements DataSource {
    private static final String NEWS_URL = "https://news.google.com/news/feeds?num=100" +
            "&q=weather+of+india&tbs=sbd:1&tbm=nws&source=lnt&output=rss";
    private static Repository ourInstance;

    public static Repository getInstance() {
        return ourInstance == null ? (ourInstance = new Repository()) : ourInstance;
    }

    private WeatherService weatherJsonService;
    private WeatherService weatherXmlService;

    private Repository() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofitJson = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/")
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        weatherJsonService = retrofitJson.create(WeatherService.class);

        Retrofit retrofitXml = new Retrofit.Builder()
                .baseUrl("https://news.google.com/news/")
                .client(client)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        weatherXmlService = retrofitXml.create(WeatherService.class);
    }

    @Override
    public void news(NewsCallback newsCallback) {
        weatherXmlService.news(NEWS_URL).enqueue(new Callback<RSS>() {
            @Override
            public void onResponse(Call<RSS> call, Response<RSS> response) {
                newsCallback.onNewsFetched(response.body().getChannel().itemList);
            }

            @Override
            public void onFailure(Call<RSS> call, Throwable t) {
                newsCallback.onError(Error.newBuilder().throwable(t).build());
            }
        });
    }

    @Override
    public void getPlaceInfo(PlaceInfoCallback placeInfoCallback) {
        weatherJsonService.placeInfo("New Delhi", "07f34b2782b5e33e7888d282c21d912e").enqueue(new Callback<PlaceInfo>() {
            @Override
            public void onResponse(Call<PlaceInfo> call, Response<PlaceInfo> response) {
                placeInfoCallback.onPlaceInfoFetched(response.body());
            }

            @Override
            public void onFailure(Call<PlaceInfo> call, Throwable t) {
                placeInfoCallback.onError(Error.newBuilder().throwable(t).build());
            }
        });
    }

    @Override
    public void getForecastInfo(ForecastInfoCallback forecastInfoCallback) {
        weatherJsonService.getForecasts("New Delhi", "07f34b2782b5e33e7888d282c21d912e").enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(Call<Forecast> call, Response<Forecast> response) {
                forecastInfoCallback.onForecastInfoFetched(response.body());
            }

            @Override
            public void onFailure(Call<Forecast> call, Throwable t) {
                forecastInfoCallback.onError(Error.newBuilder().throwable(t).build());
            }
        });
    }
}
