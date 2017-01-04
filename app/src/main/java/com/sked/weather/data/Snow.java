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
public class Snow {
    private double lastVolume;

    @JsonGetter("3h")
    public double lastVolume() {
        return lastVolume;
    }

    @JsonSetter("3h")
    public void lastVolume(double lastVolume) {
        this.lastVolume = lastVolume;
    }
}
