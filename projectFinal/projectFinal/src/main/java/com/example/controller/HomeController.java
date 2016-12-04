package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ebastic on 12/4/2016.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String homepage(){
        return "redirect:/user/cities";
    }
}
