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
public class Parameters {
    /*{"temp":293.25,"pressure":1019,"humidity":83,"temp_min":289.82,"temp_max":295.37},*/
    private double temperature;
    private double pressure;
    private double humidity;
    private double minimumTemperature;
    private double maximumTemperature;
    private double seaLevel;

    @JsonGetter("grnd_level")
    public double groundLevel() {
        return groundLevel;
    }

    @JsonSetter("grnd_level")
    public void groundLevel(double groundLevel) {
        this.groundLevel = groundLevel;
    }

    @JsonGetter("sea_level")
    public double seaLevel() {
        return seaLevel;
    }

    @JsonSetter("sea_level")
    public void seaLevel(double seaLevel) {
        this.seaLevel = seaLevel;
    }

    private double groundLevel;

    @JsonGetter("temp")
    public double temperature() {
        return temperature;
    }

    @JsonSetter("temp")
    public void temperature(double temperature) {
        this.temperature = temperature;
    }

    @JsonGetter("pressure")
    public double pressure() {
        return pressure;
    }

    @JsonSetter("pressure")
    public void pressure(double pressure) {
        this.pressure = pressure;
    }

    @JsonGetter("humidity")
    public double humidity() {
        return humidity;
    }

    @JsonSetter("humidity")
    public void humidity(double humidity) {
        this.humidity = humidity;
    }

    @JsonGetter("temp_min")
    public double minimumTemperature() {
        return minimumTemperature;
    }

    @JsonSetter("temp_min")
    public void minimumTemperature(double minimumTemperature) {
        this.minimumTemperature = minimumTemperature;
    }

    @JsonGetter("temp_max")
    public double maximumTemperature() {
        return maximumTemperature;
    }

    @JsonSetter("temp_max")
    public void maximumTemperature(double maximumTemperature) {
        this.maximumTemperature = maximumTemperature;
    }
}
