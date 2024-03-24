package com.springdatajpa.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdatajpa.springboot.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
