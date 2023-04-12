package com.ztpai.projekt.meeme.controller;

import com.ztpai.projekt.meeme.data.User;
import com.ztpai.projekt.meeme.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    UserRepository repository = new UserRepository();

    @PostMapping("/register")
    public String register(@RequestBody Map<String, String> params){
        String login = params.get("login");
        String password = params.get("password");
        String email = params.get("email");

        if(login.length()<4){
            return "Login should have at least 4 characters!";
        }
        else if(login.length()>16){
            return "Login is too long!";
        }

        repository.addUser(login,password,email);

        return "You have successfully created an account!";
    }

    @PostMapping("/login")
    public void login(@RequestBody Map<String, String> params){

    }
}
