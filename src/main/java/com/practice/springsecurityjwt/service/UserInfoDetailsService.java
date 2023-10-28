package com.practice.springsecurityjwt.service;

import com.practice.springsecurityjwt.entity.UserInfo;
import com.practice.springsecurityjwt.model.UserInfoDetails;
import com.practice.springsecurityjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> user = Optional.ofNullable(userRepository.findByName(username));

        return user.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("No user found"));

    }
}
