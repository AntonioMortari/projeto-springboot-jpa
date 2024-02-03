package com.course.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.course.entitites.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
