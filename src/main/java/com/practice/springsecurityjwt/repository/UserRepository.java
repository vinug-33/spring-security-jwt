package com.practice.springsecurityjwt.repository;


import com.practice.springsecurityjwt.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Integer> {
    UserInfo findByName(String username);
}
