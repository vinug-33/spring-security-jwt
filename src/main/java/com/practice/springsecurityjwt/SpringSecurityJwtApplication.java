package com.practice.springsecurityjwt;

import com.practice.springsecurityjwt.entity.UserInfo;
import com.practice.springsecurityjwt.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityJwtApplication {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}

	@PostConstruct
	public void loadData(){
		UserInfo user = new UserInfo();
		user.setName("user");
		user.setEmail("user@gmail.com");
		user.setPassword(passwordEncoder.encode("password"));
		user.setRoles("ROLE_USER");
		userRepository.save(user);

		UserInfo admin = new UserInfo();
		admin.setName("admin");
		admin.setEmail("admin@gmail.com");
		admin.setPassword(passwordEncoder.encode("password"));
		admin.setRoles("ROLE_ADMIN");
		userRepository.save(admin);

		System.out.println("Users added to DB");
	}
}
