package com.course.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.course.course.entitites.User;
import com.course.course.repositories.UserRepository;
import com.course.course.services.exceptions.DatabaseException;
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
		try {
			findOne(id);
			repository.deleteById(id);
		}catch(ResourceNotFoundException e) {	
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		try {
			User entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
		
		
	}
	
	public void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		entity.setPassword(obj.getPassword());
	}
	
}
