package com.springdatajpa.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springdatajpa.springboot.entity.ProductCategory;
import com.springdatajpa.springboot.service.ProductCategoryService;

@RestController
public class ProductCategoryController {
	
	// one to many bidirectional mapping
	
	@Autowired
	private ProductCategoryService productCategoryService;
	
	
	@PostMapping("/saveProductCategory")
	public void saveProductCategoryWithProducts(@RequestBody ProductCategory productCategory) {
		productCategoryService.saveProductCategory(productCategory);
	}
	
	// not working returning multiple instances
	@GetMapping("/findProductCategory")
	public ProductCategory retrieveProductCategory(@RequestParam Long id) {
		return productCategoryService.getProductCategory(id);
	}

}
