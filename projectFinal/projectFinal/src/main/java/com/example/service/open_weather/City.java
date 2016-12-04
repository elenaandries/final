package com.example.service.open_weather;

/**
 * Created by ebastic on 11/27/2016.
 */
public class City {

    private Long id;
    private String name;
    private Coord coord;
    private String country;
    private int population;
    private Object sys;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coord getCoord() {
        return coord;
    }

    public String getCountry() {
        return country;
    }

    public int getPopulation() {
        return population;
    }

    public Object getSys() {
        return sys;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coord=" + coord +
                ", country='" + country + '\'' +
                ", population=" + population +
                ", sys=" + sys +
                '}';
    }
}
