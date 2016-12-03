package com.example.service;

import com.example.service.open_weather.Forecast;
import com.example.service.open_weather.Main;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by ebastic on 11/25/2016.
 */
@Service
public class WeatherService {

    public final static String APPID = "ad3dc2bf458b4b3898de96a03a2b46f2";
    public final static String UNITS = "&units=metric";

    public static String constructURL(String city){
        String URL = "http://api.openweathermap.org/data/2.5/forecast?";
        URL += city;
        URL += "&mode=json&units=metric&appid=";
        URL += APPID;

        return URL;
    }

    public Forecast getForecast(String city){
        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter jsonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
        restTemplate.getMessageConverters().add(jsonHttpMessageConverter);

        return restTemplate.getForObject("http://api.openweathermap.org/data/2.5/forecast?q=" + city + ",us&mode=json" + UNITS + "&appid=" + APPID, Forecast.class);
    }

    public Main getMain(String city) {
        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter jsonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
        restTemplate.getMessageConverters().add(jsonHttpMessageConverter);
        return restTemplate.getForObject("http://api.openweathermap.org/data/2.5/forecast?q=" + city + ",us&mode=json" + UNITS + "&appid=" + APPID, Main.class);
    }


}
