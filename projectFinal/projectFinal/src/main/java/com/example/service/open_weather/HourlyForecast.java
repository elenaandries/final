package com.example.service.open_weather;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by ebastic on 11/27/2016.
 */
public class HourlyForecast {

    private long dt;
    private Main main;
    private List<Weather> weather;
    private Object clouds;
    private Wind wind;
    private Object rain;
    private Object snow;
    private Object sys;
    private String text;

    public long getDt() {
        return dt;
    }

    public String timestampToString() {
        Date time = new Date(this.dt*1000);
        SimpleDateFormat sdf = new SimpleDateFormat("H:mm", Locale.UK);
        String date = sdf.format(time);

        return date.toString();
    }

    public String getDay() {
        Date time = new Date(this.dt*1000);
        SimpleDateFormat sdf = new SimpleDateFormat("MMM d", Locale.UK);
        String date = sdf.format(time);

        return date.toString();
    }

    public Main getMain() {
        return main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public Object getClouds() {
        return clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public Object getRain() {
        return rain;
    }

    public Object getSnow() {
        return snow;
    }

    public Object getSys() {
        return sys;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "HourlyForecast{" +
                "dt=" + dt +
                ", main=" + main +
                ", weather=" + weather +
                ", clouds=" + clouds +
                ", wind=" + wind +
                ", rain=" + rain +
                ", snow=" + snow +
                ", sys=" + sys +
                ", text='" + text + '\'' +
                '}';
    }
}
