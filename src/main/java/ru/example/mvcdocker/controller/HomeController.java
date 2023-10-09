package ru.example.mvcdocker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Dev team
 */

@Controller
public class HomeController {
    @GetMapping("/")
    public String getHomePage(){
        return "index";
    }
}
