package com.springdatajpa.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdatajpa.springboot.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String name);

}
