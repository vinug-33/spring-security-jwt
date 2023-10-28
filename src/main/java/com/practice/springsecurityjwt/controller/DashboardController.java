package com.practice.springsecurityjwt.controller;

import com.practice.springsecurityjwt.model.UserRequest;
import com.practice.springsecurityjwt.service.JwtService;
import com.practice.springsecurityjwt.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/dashboard")
public class DashboardController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/home")
    public String homePage(){
        return "Welcome to homepage!";
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/user")
    public String getUserPage(){
        return "Welcome User!!!!";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String getAdminPage(){
        return "Welcome Admin!!!!";
    }

    @PostMapping("/authenticate")
    public String authenticateAndGenerateToken(@RequestBody UserRequest userRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.getName(), userRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(userRequest.getName());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }


}
