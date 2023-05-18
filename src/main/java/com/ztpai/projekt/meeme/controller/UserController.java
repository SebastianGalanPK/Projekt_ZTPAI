package com.ztpai.projekt.meeme.controller;

import com.ztpai.projekt.meeme.data.User;
import com.ztpai.projekt.meeme.data.dto.LoginDto;
import com.ztpai.projekt.meeme.data.dto.RegisterDto;
import com.ztpai.projekt.meeme.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserRepository repository;

    @PostMapping("/register")
    public ResponseEntity<String> register(@ModelAttribute("RegisterDto") RegisterDto registerDto){
        if(repository.findByLogin(registerDto.getLogin())!=null){
            return new ResponseEntity<>("Login is already taken!", HttpStatus.BAD_REQUEST);
        }
        if(repository.findByEmail(registerDto.getEmail())!=null){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        User user = new User(registerDto.getLogin(), BCrypt.hashpw(registerDto.getPassword(), BCrypt.gensalt()), registerDto.getEmail());
        repository.save(user);

        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("LoginDto") LoginDto loginDto){
        User user = repository.findByLogin(loginDto.getLogin());

        if(user==null){
            return "There is no user with given login and password!";
        }
        else{
            if(BCrypt.checkpw(loginDto.getPassword(), user.getPassword())){
                return "There is no user with given login and password!";
            }
        }

        return "User login success!";
    }
}
