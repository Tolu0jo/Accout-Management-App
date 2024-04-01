package com.example.springsecurity.service;

import com.example.springsecurity.entity.User;
import com.example.springsecurity.model.UserModel;
import org.springframework.stereotype.Service;

public interface UserService {
    User register(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);
}
