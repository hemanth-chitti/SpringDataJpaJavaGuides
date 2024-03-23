package com.springdatajpa.springboot.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.springdatajpa.springboot.entity.Product;
import com.springdatajpa.springboot.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/getProducts")
	public List<Product> retrieveAllProducts() {
		return productService.getAllProducts();
		
	}
	
	@PostMapping("/saveProduct")
	public void saveOneProduct(@RequestBody Product product) {
		productService.saveProduct(product);
	}
	
	@PutMapping("/updateProduct/{id}")
	public void updateOneProduct(@PathVariable Long id, @RequestBody Product product) {
		productService.updateProduct(id, product);
	}
	
	@PostMapping("/saveProducts")
	public void saveProducts(@RequestBody List<Product> products) {
		productService.saveProducts(products);
		
	}
	
	@DeleteMapping("/deleteProductById/{id}")
	public void deleteProductBasedOnId(@PathVariable Long id) {
		productService.deleteProductById(id);
	}
	
	@DeleteMapping("/deleteProductEntity/{id}")
	public void deleteProductBasedonEntity(@PathVariable Long id) {
		productService.deleteByEntity(id);
	}
	
	@DeleteMapping("/deleteAllProducts")
	public void deleteAllProductsFromDB() {
		productService.deleteAllProducts();
	}
	
	@GetMapping("/countProducts")
	public Long countNoOfProducts() {
		return productService.countproducts();
		
	}
	
	@GetMapping("/existProduct/{id}")
	public boolean checkProduct(@PathVariable Long id) {
		return productService.existByid(id);
		
	}
	
	/////////////////////////////////////Query Methods Start /////////////////////////////////////
	
	@GetMapping("/getProductByName/{name}")
	public Product retrieveProductByName(@PathVariable String name) {
		return productService.getProductByName(name);
	}
	
	@GetMapping("/findProductById/{id}")
	public Product retrieveProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}

	
	@GetMapping("/getProductsByNameAndDescriotion")
	public List<Product> retrieveProductsByNameAndDescription(@RequestParam String name, @RequestParam String description){
		// url used -> http://localhost:8080/getProductsByNameAndDescriotion?name=RemoteCar&description=belongs to toys
		return productService.getProductsByNameAndDecription(name, description);
	}
	
	@GetMapping("/getProductsByNameOrDescriotion")
	public List<Product> retieveProductsByNameOrDescription(@RequestParam String name, @RequestParam String description){
		// url used -> http://localhost:8080/getProductsByNameOrDescriotion?name=RemoteCar&description=belongs to toys
		return productService.getProductsByNameOrDescription(name, description);
	}
	
	@GetMapping("/getUniueProductByName")
	public Product retrieveUniqueProductByName(@RequestParam String name) {
		return productService.getUniqueProductByName(name);
	}
	
	@GetMapping("/getProductsGreaterThanPrice")
	public List<Product> retrieveProductsGreaterThanPrice(@RequestParam BigDecimal price){
		// url used -> http://localhost:8080/getProductsGreaterThanPrice?price=500
		return productService.getProductsGreaterThanPrice(price);
	}
	
	@GetMapping("/getProductsLessThanPrice")
	public List<Product> retrieveProductsLessThanPrice(@RequestParam BigDecimal price){
		// url used -> http://localhost:8080/getProductsLessThanPrice?price=700
		return productService.getProductsLessThanPrice(price);
	}
	
	@GetMapping("/getProductsContainingSameName")
	public List<Product> retrieveProductsContainingSameName(@RequestParam String name){
		// url used -> http://localhost:8080/getProductsContainingSameName?name=RemoteCar
		return productService.getProductsContainingSameName(name);
	}
	
	@GetMapping("/getProductsBetweenPrice")
	public List<Product> retrieveProductsBetweenPrice(@RequestParam BigDecimal startPrice, @RequestParam BigDecimal endPrice){
		// url used -> http://localhost:8080/getProductsBetweenPrice?startPrice=100&endPrice=700
		return productService.getProductsBtweenPrice(startPrice, endPrice);
	}
	
	// Not working
	@GetMapping("/getProductsBetweenDate")
	public List<Product> retrieveProductsBetweenDate(@RequestParam String localStartDateTime, @RequestParam String localEndDateTime) {
		// url used -> http://localhost:8080/getProductsBetweenPrice?startPrice=100&endPrice=700
		
		
		System.out.println("start date "+localStartDateTime);
		
		LocalDateTime startDateTime = LocalDateTime.parse(localStartDateTime);
		
		
		LocalDateTime endDateTime = LocalDateTime.parse(localEndDateTime);
		
		return productService.getProductsBtweenDate(startDateTime, endDateTime);
	}
	
	@GetMapping("/getProductsInListOfNames")
	public List<Product> retrieveProductsBetweenDate(@RequestParam List<String> name){
		// url used -> http://localhost:8080/getProductsInListOfNames?name=RemoteCar,JCB
		return productService.getProductsInListOfNames(name);
		
	}
	
	@GetMapping("/getProductsOrderByPrice")
	public List<Product> retrieveProductsOrderByPrice(){
		return productService.getProductsOrderByPrice();
		
	}
	
	@GetMapping("/getFirstTwoProductsOrderByPrice")
	public List<Product> retrieveFirstTwoProductsOrderByPrice(){
		return productService.getFirstTwoProductsOrderByPrice();
		
	}
	
}
