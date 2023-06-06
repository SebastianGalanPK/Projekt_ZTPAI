package com.ztpai.projekt.meeme.auth;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class DataVerification {
    String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public String checkLogin(String login){
        int length = login.length();

        if(length<5){
            return "Login should have at least 8 letters!";
        }

        if(length>16){
            return "Login should have less than 16 letters!";
        }

        if(login.contains(" ")){
            return "Login cannot have spaces!";
        }

        return null;
    }

    public String checkPassword(String password){
        int length = password.length();

        if(length<8){
            return "Password should have at least 8 letters!";
        }

        return null;
    }

    public String checkEmail(String email){
        if(!Pattern.matches(emailPattern, email)){
            return "Your email is incorrect";
        }

        return null;
    }
}