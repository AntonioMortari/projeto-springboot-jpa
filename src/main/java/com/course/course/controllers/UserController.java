package com.course.course.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.course.entitites.User;
import com.course.course.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		List<User> result = service.findAll();
		
		return ResponseEntity.ok().body(result);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<User>> findOne(@PathVariable Long id){
		Optional<User> user = service.findOne(id);
		
		return ResponseEntity.ok().body(user);
	}
	
}
