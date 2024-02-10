package com.course.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.course.entitites.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
