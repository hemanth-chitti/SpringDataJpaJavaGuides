package com.springdatajpa.springboot.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdatajpa.springboot.entity.Role;
import com.springdatajpa.springboot.entity.User;
import com.springdatajpa.springboot.repository.RoleRepository;
import com.springdatajpa.springboot.repository.UserRepository;

@Service
public class RoleService {

	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	public void saveRole(Role role) {
		
		 Set<User> users = role.getUsers();
	        if (users != null) {
	            for (User user : users) {
	                // Find the user by email (assuming email is unique)
	                User existingUser = userRepository.findByEmail(user.getEmail());
	                if (existingUser != null) {
	                	System.out.println("if called");
	                    // If the user exists, add the role to the user's roles
	                    initializeRoles(existingUser);
	                    existingUser.getRoles().add(role);
	                    // Update the user with the new role association
	                    userRepository.save(existingUser);
	                } else {
	                	System.out.println("else called");
	                    // If the user doesn't exist, create a new user and add the role
	                    initializeRoles(user);
	                    user.getRoles().add(role);
	                    userRepository.save(user);
	                }
	            }
	        }
	        // Save the role after updating user associations
	        roleRepository.save(role);
	    }

	    // Helper method to initialize the roles set if it's null
	    private void initializeRoles(User user) {
	        if (user.getRoles() == null) {
	            user.setRoles(new HashSet<>());
	        }
	    }
	
}
