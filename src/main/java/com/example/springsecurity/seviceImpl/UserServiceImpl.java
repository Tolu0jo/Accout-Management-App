package com.example.springsecurity.seviceImpl;

import com.example.springsecurity.entity.User;
import com.example.springsecurity.model.UserModel;
import com.example.springsecurity.repository.UserRepository;
import com.example.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User register(UserModel userModel) {
       User user = new User();
       user.setEmail(userModel.getEmail());
       user.setFirstName(userModel.getFirstName());
       user.setLastName(userModel.getLastName());
       user.setRole("USER");
       user.setPassword(passwordEncoder.encode(userModel.getPassword()));
       userRepository.save(user);
       return user;
    }
}
