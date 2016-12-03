package com.example.controller;

import com.example.service.WeatherService;
import com.example.service.open_weather.Forecast;
import com.example.service.open_weather.Main;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ebastic on 11/25/2016.
 */
@Controller
@RequestMapping("/weather")
public class WeatherController {

    @RequestMapping(path="/save", method = RequestMethod.GET)
    public String create(){
        return "weather/list";
    }

    @RequestMapping(path="/list", method = RequestMethod.GET)
    @ResponseBody
    public String getForecast(){
        WeatherService wr = new WeatherService();
        Forecast fr = wr.getForecast("london");

        return fr.getCity().toString();
    }

    @RequestMapping(path="/list2", method = RequestMethod.GET)
    @ResponseBody
    public String getMain(){
        WeatherService wr = new WeatherService();
        Main mn =  wr.getMain("london");

        return mn.toString();
    }

}
