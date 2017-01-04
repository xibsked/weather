package com.sked.weather.data;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * MachineLearning, All rights Reserved
 * Created by Sanjeet on 24-Nov-16.
 */

@Root
public class RSS implements Serializable {
    @Attribute
    private
    String version;
    @Element
    private
    Channel channel;

    public Channel getChannel() {
        return channel;
    }

    @Override
    public String toString() {
        return "RSS{" +
                "version='" + version + '\'' +
                ", channel=" + channel +
                '}';
    }
}
