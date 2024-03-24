package com.springdatajpa.springboot.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdatajpa.springboot.entity.Role;
import com.springdatajpa.springboot.entity.User;
import com.springdatajpa.springboot.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository; 
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	
	public void updateUser(Long id, User user) {
		User existingUser = userRepository.findById(id).get();
		
		existingUser.setEmail(user.getEmail());
		
		Set<Role> roles = user.getRoles();
		
		for (Role role : roles) {
			existingUser.getRoles().add(role);
		}
		
		userRepository.save(existingUser);
	}
	
	public User getUser(Long id) {
		return userRepository.findById(id).get();
	}
	
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}

}
