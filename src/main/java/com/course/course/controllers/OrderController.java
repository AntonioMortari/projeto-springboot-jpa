package com.course.course.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.course.entitites.Order;
import com.course.course.services.OrderService;

@RestController
@RequestMapping(value = "orders")
public class OrderController {
	
	@Autowired
	private OrderService service;

	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> orders = service.findAll();
		
		return ResponseEntity.ok().body(orders);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Order>> findOne(@PathVariable Long id){
		Optional<Order> order = service.findOne(id);
		
		return ResponseEntity.ok().body(order);
	}
	
}
