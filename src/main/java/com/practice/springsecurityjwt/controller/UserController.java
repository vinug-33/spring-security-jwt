package com.practice.springsecurityjwt.controller;

import com.practice.springsecurityjwt.entity.UserInfo;
import com.practice.springsecurityjwt.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/add")
    public String addUser(UserInfo user){
        return userService.addUser(user);
    }
}
