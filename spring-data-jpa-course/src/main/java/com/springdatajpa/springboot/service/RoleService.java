package com.springdatajpa.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdatajpa.springboot.repository.RoleRepository;

@Service
public class RoleService {

	
	@Autowired
	private RoleRepository roleRepository;
	
}
