package com.sked.weather.data;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.sked.weather.data.remote.Wind;

import java.util.List;

/**
 * Weather, All rights Reserved
 * Created by Sanjeet on 01-Jan-17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceInfo {
    private int id;
    private String name;
    private int code;
    private Location location;
    private List<Weather> weathers;
    private String base;
    private Parameters parameters;
    private Wind wind;
    private Cloud cloud;
    private Rain rain;
    private Snow snow;
    private System system;
    private long time;


    @JsonGetter("coord")
    public Location location() {
        return location;
    }

    @JsonSetter("coord")
    public void location(Location location) {
        this.location = location;
    }

    @JsonGetter("weather")
    public List<Weather> weathers() {
        return weathers;
    }

    @JsonSetter("weather")
    public void weathers(List<Weather> weathers) {
        this.weathers = weathers;
    }

    @JsonGetter("base")
    public String base() {
        return base;
    }

    @JsonSetter("base")
    public void base(String base) {
        this.base = base;
    }

    @JsonGetter("main")
    public Parameters parameters() {
        return parameters;
    }

    @JsonSetter("main")
    public void parameters(Parameters parameters) {
        this.parameters = parameters;
    }

    @JsonGetter("wind")
    public Wind wind() {
        return wind;
    }

    @JsonSetter("wind")
    public void wind(Wind wind) {
        this.wind = wind;
    }

    @JsonGetter("clouds")
    public Cloud cloud() {
        return cloud;
    }

    @JsonSetter("clouds")
    public void cloud(Cloud cloud) {
        this.cloud = cloud;
    }

    @JsonGetter("rain")
    public Rain rain() {
        return rain;
    }

    @JsonSetter("rain")
    public void rain(Rain rain) {
        this.rain = rain;
    }

    @JsonGetter("snow")
    public Snow snow() {
        return snow;
    }

    @JsonSetter("snow")
    public void snow(Snow snow) {
        this.snow = snow;
    }

    @JsonGetter("dt")
    public long time() {
        return time;
    }

    @JsonSetter("dt")
    public void time(long time) {
        this.time = time;
    }

    @JsonGetter("sys")
    public System system() {
        return system;
    }

    @JsonSetter("sys")
    public void system(System system) {
        this.system = system;
    }

    @JsonGetter("id")
    public int id() {
        return id;
    }

    @JsonSetter("id")
    public void id(int id) {
        this.id = id;
    }

    @JsonGetter("name")
    public String name() {
        return name;
    }

    @JsonSetter("name")
    public void name(String name) {
        this.name = name;
    }

    @JsonGetter("cod")
    public int code() {
        return code;
    }

    @JsonSetter("cod")
    public void code(int code) {
        this.code = code;
    }
}
