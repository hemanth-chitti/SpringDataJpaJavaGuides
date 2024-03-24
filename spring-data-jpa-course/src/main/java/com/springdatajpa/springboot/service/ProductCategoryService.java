package com.springdatajpa.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdatajpa.springboot.entity.Product;
import com.springdatajpa.springboot.entity.ProductCategory;
import com.springdatajpa.springboot.repository.ProductCategoryRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductCategoryService {
	
	// one to many bidirectional mapping
	
	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	
	
	public void saveProductCategory(ProductCategory productCategory) {
		
		List<Product> products = productCategory.getProducts();
		
		for (Product product : products) {
			
			product.setCategory(productCategory);
			
		}
		
		productCategoryRepository.save(productCategory);
	}
	
	// not working returning multiple instances
	@Transactional
	public ProductCategory getProductCategory(Long id) {
		 ProductCategory productCategory = productCategoryRepository.findById(id).get();
		 
		 return productCategory;
	}

}
