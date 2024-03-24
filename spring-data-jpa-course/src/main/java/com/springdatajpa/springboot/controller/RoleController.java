package com.springdatajpa.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springdatajpa.springboot.entity.Role;
import com.springdatajpa.springboot.service.RoleService;

@RestController
public class RoleController {	
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/saveRole")
	public void saveRoleWithUsers(@RequestBody Role role) {
		
		roleService.saveRole(role);
		
	}

}
