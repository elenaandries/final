package com.example.service.open_weather;

/**
 * Created by ebastic on 11/27/2016.
 */
public class Main {

    private String temp;
    private String temp_min;
    private String temp_max;
    private String pressure;
    private String sea_level;
    private String grnd_level;
    private String humidity;
    private String temp_kf;

    public String getTemp() {
        return temp;
    }

    public String getTemp_min() {
        return temp_min;
    }

    public String getTemp_max() {
        return temp_max;
    }

    public String getPressure() {
        return pressure;
    }

    public String getSea_level() {
        return sea_level;
    }

    public String getGrnd_level() {
        return grnd_level;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getTemp_kf() {
        return temp_kf;
    }

    @Override
    public String toString() {
        return "Main{" +
                "temp='" + temp + '\'' +
                ", temp_min='" + temp_min + '\'' +
                ", temp_max='" + temp_max + '\'' +
                ", pressure='" + pressure + '\'' +
                ", sea_level='" + sea_level + '\'' +
                ", grnd_level='" + grnd_level + '\'' +
                ", humidity='" + humidity + '\'' +
                ", temp_kf='" + temp_kf + '\'' +
                '}';
    }
}
