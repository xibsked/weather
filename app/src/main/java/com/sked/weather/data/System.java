package com.sked.weather.data;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Weather, All rights Reserved
 * Created by Sanjeet on 01-Jan-17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class System {
    private int id;
    private int type;
    private String message;
    private String countryCode;
    private long sunriseTime;
    private long sunsetTime;

    @JsonGetter("id")
    public int id() {
        return id;
    }

    @JsonSetter("id")
    public void id(int id) {
        this.id = id;
    }

    @JsonGetter("type")
    public int type() {
        return type;
    }

    @JsonSetter("type")
    public void type(int type) {
        this.type = type;
    }

    @JsonGetter("message")
    public String message() {
        return message;
    }

    @JsonSetter("message")
    public void message(String message) {
        this.message = message;
    }

    @JsonGetter("country")
    public String countryCode() {
        return countryCode;
    }

    @JsonSetter("country")
    public void countryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonGetter("sunrise")
    public long sunriseTime() {
        //Converting to ms
        return sunriseTime;
    }

    @JsonSetter("sunrise")
    public void sunriseTime(long sunriseTime) {
        this.sunriseTime = sunriseTime;
    }

    @JsonGetter("sunset")
    public long sunsetTime() {
        return sunsetTime;
    }

    @JsonSetter("sunset")
    public void sunsetTime(long sunsetTime) {
        this.sunsetTime = sunsetTime;
    }
}
