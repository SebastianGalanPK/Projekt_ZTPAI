package com.ztpai.projekt.meeme.controller;

import com.ztpai.projekt.meeme.data.Meme;
import com.ztpai.projekt.meeme.data.User;
import com.ztpai.projekt.meeme.data.dto.LoginDto;
import com.ztpai.projekt.meeme.data.dto.RegisterDto;
import com.ztpai.projekt.meeme.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserRepository repository;

    /*@PostMapping("/register")
    public ResponseEntity<String> register(@ModelAttribute("RegisterDto") RegisterDto registerDto){
        if(repository.findByLogin(registerDto.getLogin())!=null){
            return new ResponseEntity<>("Login is already taken!", HttpStatus.BAD_REQUEST);
        }
        if(repository.findByEmail(registerDto.getEmail())!=null){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }
        User user = new User(registerDto.getLogin(), registerDto.getPassword(), registerDto.getEmail());
        //User user = new User(registerDto.getLogin(), BCrypt.hashpw(registerDto.getPassword(), BCrypt.gensalt()), registerDto.getEmail());
        repository.save(user);

        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }*/

    @GetMapping("/users")
    public List<User> getAllMemes(){
        return repository.findAll();
    }


    /*@PostMapping("/login")
    public String login(@ModelAttribute("LoginDto") LoginDto loginDto){
        User user = repository.findByLogin(loginDto.getLogin());

        if(user==null){
            return "There is no user with given login and password!";
        }
        else{
            *//*if(BCrypt.checkpw(loginDto.getPassword(), user.getPassword())){
                return "There is no user with given login and password!";
            }*//*
            if(!loginDto.getPassword().equals(user.getPassword())){
                return "There is no user with given login and password!";
            }
        }

        return "User login success!";
    }*/
}
