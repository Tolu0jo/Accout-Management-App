package com.example.springsecurity.service;

import com.example.springsecurity.entity.User;
import com.example.springsecurity.model.UserModel;

public interface UserService {
    User register(UserModel userModel);
}
