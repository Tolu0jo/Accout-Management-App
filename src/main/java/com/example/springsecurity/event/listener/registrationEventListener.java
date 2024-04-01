package com.example.springsecurity.event.listener;

import com.example.springsecurity.entity.User;
import com.example.springsecurity.event.RegistrationEvent;
import com.example.springsecurity.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

@Slf4j
public class registrationEventListener implements ApplicationListener<RegistrationEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationEvent event) {
     User user = event.getUser();
     String token = UUID.randomUUID().toString();
     userService.saveVerificationTokenForUser(token, user);
     //Send Mail to User
      String url= event.getApplicationUrl() + "verifyRegistration?token="
              +token;
     //Send Verification url
      log.info("Click the link to verify your account: {}", url);
    }
}
