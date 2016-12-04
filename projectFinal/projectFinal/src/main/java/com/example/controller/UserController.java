package com.example.controller;

import com.example.model.City;
import com.example.service.CityService;
import com.example.service.UserService;
import com.example.service.WeatherService;
import com.example.service.open_weather.Forecast;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.context.SecurityContextHolder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Created by ebastic on 11/24/2016.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CityService cityService;

    @Autowired
    private WeatherService weatherService;

    @RequestMapping(path="/cities", method = RequestMethod.GET)
    public String cities(Model model, HttpServletRequest request) {
        String cityId = request.getParameter("id");

        if (cityId != null && !cityId.isEmpty()) {
            City city = cityService.findById(Long.parseLong(cityId));
            Forecast forecast =  weatherService.getForecast(city);

            model.addAttribute("forecast", forecast);
            model.addAttribute("selectedCity", city);
        }

        model.addAttribute("cities", cityService.findAll());

        return "user/cities";
    }

    @RequestMapping(path="/cities/add", method = RequestMethod.POST)
    public String saveCity(@ModelAttribute("post") com.example.dto.City city, BindingResult result, ModelMap model) {
        City obj = new City();
        obj.setName(city.getName());

        City newCity = cityService.create(obj);

        return "redirect:/user/cities?id=" + newCity.getId();
    }

    @RequestMapping(path="/logout", method=RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:/";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid credentials");
        }

        if (logout != null) {
            model.addObject("msg", "Sign out");
        }

        model.setViewName("user/login");

        return model;
    }
}
