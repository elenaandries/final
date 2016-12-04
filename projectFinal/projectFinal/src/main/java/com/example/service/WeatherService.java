package com.example.service;

import com.example.model.City;
import com.example.model.CityCache;
import com.example.service.open_weather.Forecast;
import com.example.service.open_weather.Main;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ebastic on 11/25/2016.
 */
@Service
public class WeatherService {

    @Autowired
    private CityCacheService cityCacheService;

    public final static String APPID = "ad3dc2bf458b4b3898de96a03a2b46f2";
    public final static String UNITS = "&units=metric";
    public final static String COUNTRY = "ro";

    public static String constructURL(String city){
        String URL = "http://api.openweathermap.org/data/2.5/forecast?";
        URL += city;
        URL += "&mode=json&units=metric&appid=";
        URL += APPID;

        return URL;
    }

    public void checkCache(Long id){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, -12);

        Date oneHourBack = cal.getTime();
        CityCache cityCache = getCache(id);
        if (cityCache != null && cityCache.getDate().getTime() < oneHourBack.getTime()) {
            cityCacheService.deleteCache(cityCache.getId());
        }
    }

    public Forecast getForecast(City city){
        checkCache(city.getId());
        // iau cache
        // dc nu exista, iau din api si salvez in cache si returnez
        // dc exista returnez obiectul
        Gson gson = new Gson();

        CityCache cityCache = getCache(city.getId());
        if (cityCache == null) {
            Forecast forecast = getObjectForecast(city);
            CityCache cc = new CityCache();
            cc.setId(city.getId());
            cc.setDate(new Date());
            cc.setJson(gson.toJson(forecast));
            cityCacheService.create(cc);

            return forecast;
        } else {

            return gson.fromJson(cityCache.getJson(), Forecast.class);
        }
    }

    private CityCache getCache(Long id){
        return cityCacheService.findById(id);
    }

    private Forecast getObjectForecast(City city){
        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter jsonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
        restTemplate.getMessageConverters().add(jsonHttpMessageConverter);

        return restTemplate.getForObject("http://api.openweathermap.org/data/2.5/forecast?q=" + city.getName() + "," + COUNTRY + "&mode=json" + UNITS + "&appid=" + APPID, Forecast.class);
    }
}
