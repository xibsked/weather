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
public class Location {
    private double latitude;
    private double longitude;

    public Location() {
    }

    @JsonGetter("lat")
    public double latitude() {
        return latitude;
    }

    @JsonSetter("lat")
    public void latitude(double latitude) {
        this.latitude = latitude;
    }

    @JsonGetter("lon")
    public double longitude() {
        return longitude;
    }

    @JsonSetter("lon")
    public void longitude(double longitude) {
        this.longitude = longitude;
    }
}
