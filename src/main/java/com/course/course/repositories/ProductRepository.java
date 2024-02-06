package com.course.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.course.entitites.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
