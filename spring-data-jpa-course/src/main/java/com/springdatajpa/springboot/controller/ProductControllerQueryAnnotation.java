package com.springdatajpa.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springdatajpa.springboot.entity.Product;
import com.springdatajpa.springboot.service.ProductServiceQueryAnnotation;

@RestController
public class ProductControllerQueryAnnotation {
	
	@Autowired
	private ProductServiceQueryAnnotation productServiceQueryAnnotation;
	
	// JPQL Index Param Query
	@GetMapping("/getProductNameOrDescriptionJPQLQuery")
	public List<Product> retriecveProductByNameOrDescriptonJPQLQuery(@RequestParam String name, @RequestParam String description) {
		return productServiceQueryAnnotation.getProdcutByNameOrDescription(name, description);
	}
	
	//Native SQL Index Param Query
	@GetMapping("/getProductNameOrDescriptionSQLQuery")
	public List<Product> retriecveProductByNameOrDescriptonSQLQuery(@RequestParam String name, @RequestParam String description) {
		// url used -> http://localhost:8080/getProductNameOrDescriptionSQLQuery?name=RemoteCar&description=belongs to toys
		return productServiceQueryAnnotation.getProductsByNameOrDescriptionSQLQuery(name, description);
	}
	
	//Native SQL Named Param Query
	@GetMapping("/getProductNameOrDescriptionNamedSQLQuery")
	public List<Product> retriecveProductByNameOrDescriptonNamedSQLQuery(@RequestParam String name, @RequestParam String description) {
		return productServiceQueryAnnotation.getProductsByNameOrDescriptionNamedSQLQuery(name, description);
	}

}
