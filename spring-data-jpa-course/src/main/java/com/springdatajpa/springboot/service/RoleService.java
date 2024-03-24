package com.springdatajpa.springboot.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdatajpa.springboot.entity.Role;
import com.springdatajpa.springboot.entity.User;
import com.springdatajpa.springboot.repository.RoleRepository;

@Service
public class RoleService {

	
	@Autowired
	private RoleRepository roleRepository;
	
	
	public void saveRole(Role role) {
		
        Set<User> users = role.getUser();
        for (User user : users) {
            user.getRoles().add(role);
        }
		
		roleRepository.save(role);
	}
	
}
