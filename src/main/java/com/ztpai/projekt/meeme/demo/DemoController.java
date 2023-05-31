package com.ztpai.projekt.meeme.demo;

import com.ztpai.projekt.meeme.data.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/test")
    public String sayHello(@AuthenticationPrincipal User user){
        if(user==null){
            return "User is not logged in";
        }
        else{
            return "safaw";
        }
    }
}
