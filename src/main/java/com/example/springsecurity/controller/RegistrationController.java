package com.example.springsecurity.controller;

import com.example.springsecurity.entity.User;
import com.example.springsecurity.event.RegistrationEvent;
import com.example.springsecurity.model.UserModel;
import com.example.springsecurity.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    @Autowired
    private ApplicationEventPublisher publisher;
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel, final HttpServletRequest request){
       User user = userService.register(userModel);
       publisher.publishEvent(new RegistrationEvent(user, applicationUrl(request)));
       return "Success";
    }

    private String applicationUrl(HttpServletRequest request) {
      return "http://"+ request.getServerName() +":"
              + request.getServerPort() + request.getContextPath();
    }
}
