package com.example.springsecurity.controller;

import com.example.springsecurity.entity.User;
import com.example.springsecurity.model.UserModel;
import com.example.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class RegistrationController {
    @A
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel){
       User user = userService.register(userModel);
       return "Success";
    }
}
