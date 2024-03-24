package com.springdatajpa.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.springdatajpa.springboot.service.RoleService;

@RestController
public class RoleController {
	
	@Autowired
	private RoleService roleService;

}
