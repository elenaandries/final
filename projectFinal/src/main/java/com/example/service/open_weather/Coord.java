package com.example.service.open_weather;

/**
 * Created by ebastic on 11/27/2016.
 */
public class Coord {

    private String lon;
    private String lat;

    public String getLon() {
        return lon;
    }

    public String getLat() {
        return lat;
    }

    @Override
    public String toString() {
        return "Coord{" +
                "lon='" + lon + '\'' +
                ", lat='" + lat + '\'' +
                '}';
    }
}
