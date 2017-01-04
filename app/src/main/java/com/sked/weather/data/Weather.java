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
public class Weather {
    private int id;
    private String group;
    private String description;
    private String icon;

    public Weather() {
    }

    @JsonGetter("id")
    public int id() {
        return id;
    }

    @JsonGetter("main")
    public String group() {
        return group;
    }

    @JsonGetter("description")
    public String description() {
        return description;
    }

    @JsonGetter("icon")
    public String icon() {
        return icon;
    }

    @JsonSetter("id")
    public void id(int id) {
        this.id = id;
    }

    @JsonSetter("main")
    public void group(String group) {
        this.group = group;
    }

    @JsonSetter("description")
    public void description(String description) {
        this.description = description;
    }

    @JsonSetter("icon")
    public void icon(String icon) {
        this.icon = icon;
    }
}
