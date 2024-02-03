package com.course.course.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.course.course.entitites.User;
import com.course.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		//SEED
		
		User user1 = new User(1L, "Alex", "9999999", "alex@test.com", "123admin");
		User user2 = new User(2L, "Bob", "999999877", "bob@test.com", "123admin");
		
		userRepository.save(user1);
		userRepository.save(user2);
	}
	
	
	
}
