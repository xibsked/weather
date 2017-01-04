package com.sked.weather.data;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

/**
 * Weather, All rights Reserved
 * Created by Sanjeet on 02-Jan-17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {
    private City city;
    private int code;
    private String message;
    private int count;
    private List<PlaceInfo> placeInfos;

    public Forecast() {
    }

    @JsonGetter("city")
    public City city() {
        return city;
    }

    @JsonSetter("city")
    public void city(City city) {
        this.city = city;
    }

    @JsonGetter("cod")
    public int code() {
        return code;
    }

    @JsonSetter("cod")
    public void code(int code) {
        this.code = code;
    }

    @JsonGetter("message")
    public String message() {
        return message;
    }

    @JsonSetter("message")
    public void message(String message) {
        this.message = message;
    }

    @JsonGetter("cnt")
    public int count() {
        return count;
    }

    @JsonSetter("cnt")
    public void count(int count) {
        this.count = count;
    }

    @JsonGetter("list")
    public List<PlaceInfo> placeInfos() {
        return placeInfos;
    }

    @JsonSetter("list")
    public void placeInfos(List<PlaceInfo> placeInfos) {
        this.placeInfos = placeInfos;
    }
}
