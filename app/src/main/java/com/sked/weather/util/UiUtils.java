package com.sked.weather.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * MachineLearning, All rights Reserved
 * Created by Sanjeet on 05-Dec-16.
 */

public class UiUtils {
    public static String url(String all) {
        String s = "<img src=\"";
        int ix = all.indexOf(s) + s.length();
        return "http:" + all.substring(ix, all.indexOf("\"", ix + 1));
    }

    public static String localeDate(String dateString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.getDefault());
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date == null ? dateString : date.toString();
    }

    public static String getIconUrl(String code) {
        return "http://openweathermap.org/img/w/" + code + ".png";
    }
}
