package com.course.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.course.entitites.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
}
