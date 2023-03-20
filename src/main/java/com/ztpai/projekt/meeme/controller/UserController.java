package com.ztpai.projekt.meeme.controller;

import com.ztpai.projekt.meeme.data.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public class UserController {

    @PostMapping("/register")
    public void register(@RequestBody User user){

    }

    @PostMapping("/login")
    public  void login(@RequestBody Map<String, String> params){

    }
}
