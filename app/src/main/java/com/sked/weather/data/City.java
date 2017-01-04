package com.sked.weather.data;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Weather, All rights Reserved
 * Created by Sanjeet on 02-Jan-17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class City {
    private int id;
    private String name;
    private Location location;
    private String country;
    private int population;
    private System system;

    public City() {
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

    @JsonGetter("coord")
    public Location location() {
        return location;
    }

    @JsonSetter("coord")
    public void location(Location location) {
        this.location = location;
    }

    @JsonGetter("country")
    public String country() {
        return country;
    }

    @JsonSetter("country")
    public void country(String country) {
        this.country = country;
    }

    @JsonGetter("population")
    public int population() {
        return population;
    }

    @JsonSetter("population")
    public void population(int population) {
        this.population = population;
    }

    @JsonGetter("sys")
    public System system() {
        return system;
    }

    @JsonSetter("sys")
    public void system(System system) {
        this.system = system;
    }
}
