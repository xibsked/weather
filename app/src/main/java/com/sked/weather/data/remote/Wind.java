package com.sked.weather.data.remote;

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
public class Wind {
    private double speed;
    private double angle;

    @JsonGetter("speed")
    public double speed() {
        return speed;
    }

    @JsonSetter("speed")
    public void speed(double speed) {
        this.speed = speed;
    }

    @JsonGetter("deg")
    public double angle() {
        return angle;
    }

    @JsonSetter("deg")
    public void angle(double angle) {
        this.angle = angle;
    }
}
