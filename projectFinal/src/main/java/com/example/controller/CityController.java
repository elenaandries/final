package com.example.controller;

import com.example.model.City;
import com.example.model.User;
import com.example.service.CityService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by ebastic on 11/22/2016.
 */
@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private UserService userService;

    @RequestMapping(path="/all")
    public String list() {
        return "city/list";
    }

    @RequestMapping(path="/list", method = RequestMethod.GET)
    @ResponseBody
    public List<City> getAllCities(){

        return cityService.findAll();
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public String searchForm(Model model) {

        model.addAttribute("cities", cityService.findAll());
        return "city/listare";
    }

    @RequestMapping(path="/addCity", method= RequestMethod.GET)
    public String adauga(@ModelAttribute("post")City city, ModelMap model) {
        model.addAttribute("mediaFiles", cityService.findAll());
        return "city/addCity";
    }

    @RequestMapping(path="/addCity", method = RequestMethod.POST)
    public String saveCity(@ModelAttribute("post") City city, BindingResult result, ModelMap model) {
        City newCity = cityService.create(city);

        return "redirect:/city/listare";
    }

    @RequestMapping(value="/{id}/delete", method = RequestMethod.GET)
    public String deleteCity(@PathVariable Integer id) {
        cityService.delete(id);
        return "redirect:/user/cities";
    }

/*
    @RequestMapping(value="/{name}", method = RequestMethod.PUT)
    public String updateUserCity(@RequestBody City city, @PathVariable String name) {
        userService.update();
        User user = userService.findByCredentials()

        return "redirect:user/list";
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.PUT)
    public List<City> updateUserCity(@RequestBody City city,@PathVariable String name){
    userService.updateCities(city, name);
    User user = userService.findByName(name);
    return user.getCities();
    }*/

}