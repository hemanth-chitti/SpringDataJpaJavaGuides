package com.springdatajpa.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springdatajpa.springboot.entity.User;
import com.springdatajpa.springboot.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/saveUser")
	public void saveUserWithRoles(@RequestBody User user) {
		userService.saveUser(user);
	}
	
	@PostMapping("/updateUser")
	public void updateUserWithRoles(@RequestParam Long id, @RequestBody User user) {
		userService.updateUser(id, user);
	}
	
	@GetMapping("/findUserById")
	public User findUserWithRoles(@RequestParam Long id) {
		return userService.getUser(id);
	}
		
	@DeleteMapping("/deleteUserById")
	public void deleteUser(@RequestParam Long id) {
		userService.deleteUserById(id);
	}

}
