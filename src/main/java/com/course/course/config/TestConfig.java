package com.course.course.config;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.course.course.entitites.Category;
import com.course.course.entitites.Order;
import com.course.course.entitites.User;
import com.course.course.entitites.enums.OrderStatus;
import com.course.course.repositories.CategoryRepository;
import com.course.course.repositories.OrderRepository;
import com.course.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	

	@Override
	public void run(String... args) throws Exception {
		//SEED
		
		User u1 = new User(1L, "Alex", "9999999", "alex@test.com", "123admin");
		User u2 = new User(2L, "Bob", "999999877", "bob@test.com", "123admin");
		User u3 = new User(3L, "Carla", "8889334", "carla@test.com", "123admin");
		
		System.out.print(OrderStatus.WAITING_PAYMENT);
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, u1); 
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.PAID, u1); 
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers"); 
		
		userRepository.save(u1);
		userRepository.save(u2);
		userRepository.save(u3);
		
		orderRepository.save(o1);
		orderRepository.save(o2);
		orderRepository.save(o3);
		
		categoryRepository.save(cat1);
		categoryRepository.save(cat2);
		categoryRepository.save(cat3);
	}
	
	
	
}
