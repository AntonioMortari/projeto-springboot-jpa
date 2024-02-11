package com.course.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.course.entitites.User;
import com.course.course.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public Optional<User> findOne(Long id) {
		Optional<User> user = repository.findById(id);
		
		return user;
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
}
