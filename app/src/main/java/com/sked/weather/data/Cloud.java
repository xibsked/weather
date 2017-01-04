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
public class Cloud {

    public Cloud() {
    }

    private double all;

    @JsonGetter("all")
    public double all() {
        return all;
    }

    @JsonSetter("all")
    public void all(double all) {
        this.all = all;
    }
}
