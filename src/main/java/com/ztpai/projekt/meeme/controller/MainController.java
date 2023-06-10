package com.ztpai.projekt.meeme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String mainPage(){
        return "/views/home.html";
    }

    @RequestMapping("/home")
    public String home(){
        return "/views/home.html";
    }

    @RequestMapping("/signIn")
    public String signIn(){
        return "/views/signIn.html";
    }

    @RequestMapping("/signUp")
    public String signUp(){
        return "/views/signUp.html";
    }
}
