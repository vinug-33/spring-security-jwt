package com.practice.springsecurityjwt.service;

import com.practice.springsecurityjwt.entity.UserInfo;
import com.practice.springsecurityjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public String addUser(UserInfo userBody) {
        UserInfo newUser = new UserInfo();
        newUser.setName(userBody.getName());
        newUser.setEmail(userBody.getEmail());
        newUser.setPassword(passwordEncoder.encode(userBody.getPassword()));
        newUser.setRoles(userBody.getRoles());

        userRepository.save(newUser);
        return "User has been added!";
    }
}
