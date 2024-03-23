package com.springdatajpa.springboot.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdatajpa.springboot.entity.Product;
import com.springdatajpa.springboot.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAllProducts(){
		
		List<Product> findAll = productRepository.findAll();

		for (Product product : findAll) {
			System.out.println("Product "+product.toString());
		}
		
		return productRepository.findAll();
		
	}
	
	public void saveProduct(Product product) {
		
		productRepository.save(product);
	}
	
	
	public void updateProduct(Long id, Product product) {
		
		System.out.println("Id "+id);
		
		// set the price for existing product by getting the price from new product
		Product existingProduct = productRepository.findById(id).get();
		
		existingProduct.setPrice(product.getPrice());
		
		productRepository.save(existingProduct);
		
	}
	
	public void saveProducts(List<Product> products) {
		
		productRepository.saveAll(products);
		
	}
	
	public void deleteProductById(Long id) {
		
		Product product = productRepository.findById(id).get();
		
		if(product!=null) {
			productRepository.deleteById(id);
		}
		
	}
	
	public void deleteByEntity(Long id) {
		Product product = productRepository.findById(id).get();
		
		if(product!=null) {
			productRepository.delete(product);
		}
	}
	
	public void deleteAllProducts() {
		productRepository.deleteAll();
	}
	
	public Long countproducts() {
		long count = productRepository.count();
		
		return count;
	}
	
	public boolean existByid(Long id) {
		boolean existsById = productRepository.existsById(id);
		return existsById;
	}
	
		///////////////////////////////////// Query Methods Start /////////////////////////////////////
	
	public Product getProductByName(String name) {
		return productRepository.findByName(name);
	}
	
	
	public Product getProductById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		return product.get();
	}
	
	public List<Product> getProductsByNameAndDecription(String name, String description){
		return productRepository.findByNameAndDescription(name, description);
	}
	
	public List<Product> getProductsByNameOrDescription(String name, String description){
		return productRepository.findByNameOrDescription(name, description);
	}
	
	public Product getUniqueProductByName(String name) {
		return productRepository.findDistinctByName(name);
	}
	
	public List<Product> getProductsGreaterThanPrice(BigDecimal price){
		return productRepository.findByPriceGreaterThan(price);
	}

	public List<Product> getProductsLessThanPrice(BigDecimal price){
		return productRepository.findByPriceLessThan(price);
	}
	
	public List<Product> getProductsContainingSameName(String name){
		return productRepository.findByNameContaining(name);
	}
	
	public List<Product> getProductsBtweenPrice(BigDecimal startPrice, BigDecimal endPrice){
		return productRepository.findByPriceBetween(startPrice, endPrice);
	}
	
	// Not Working
	public List<Product> getProductsBtweenDate(LocalDateTime startDate, LocalDateTime endDate){
		return productRepository.findByDateCreatedBetween(startDate, endDate);
	}
	
	public List<Product> getProductsInListOfNames(List<String> name){
		return productRepository.findByNameIn(name);
	}
	
	public List<Product> getProductsOrderByPrice(){
		return productRepository.findByOrderByPrice();
	}
	
	public List<Product> getFirstTwoProductsOrderByPrice(){
		return productRepository.findFirst2ByOrderByPrice();
	}
}
