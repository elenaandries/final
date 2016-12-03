package com.example.service.open_weather;

import java.util.List;

/**
 * Created by ebastic on 11/27/2016.
 */
public class Forecast {

    private City city;
    private int cod;
    private String message;
    private int cnt;
    private List<HourlyForecast> list;

    public City getCity() {
        return city;
    }

    public int getCod() {
        return cod;
    }

    public String getMessage() {
        return message;
    }

    public int getCnt() {
        return cnt;
    }

    public List<HourlyForecast> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "city=" + city +
                ", cod=" + cod +
                ", message='" + message + '\'' +
                ", cnt=" + cnt +
                ", list=" + list +
                '}';
    }
}
