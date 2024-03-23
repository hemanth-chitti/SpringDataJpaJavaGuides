package com.springdatajpa.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdatajpa.springboot.entity.Product;
import com.springdatajpa.springboot.repository.ProductRepository;

@Service
public class ProductServiceQueryAnnotation {
	
	@Autowired
	private ProductRepository productRepository;
	
	// JPQL Index Param Query
	public List<Product> getProdcutByNameOrDescription(String name, String description) {
		return productRepository.findByNameOrDescriptionIndexParam(name, description);
	}
	
	//Native SQL Index Param Query
	public List<Product> getProductsByNameOrDescriptionSQLQuery(String name, String description){
		return productRepository.findByNameOrDescriptionSQLIndexParam(name, description);
	}
	
	//Native SQL Named Param Query
	public List<Product> getProductsByNameOrDescriptionNamedSQLQuery(String name, String description){
		return productRepository.findByNameOrDescriptionNamedSQLQuery(name, description);
	}

}
