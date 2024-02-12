package com.course.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.course.entitites.User;
import com.course.course.repositories.UserRepository;
import com.course.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findOne(Long id) {
		User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		return user;
		
		
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	public void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		entity.setPassword(obj.getPassword());
	}
	
}
