package com.springdatajpa.springboot.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springdatajpa.springboot.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	////////////////Query Methods start ///////////////////////////////
	
	
	public Product findByName(String name);
	
	public Optional<Product> findById(Long id);
	
	// url used -> http://localhost:8080/getProductsByNameAndDescriotion?name=RemoteCar&description=belongs to toys
	public List<Product> findByNameAndDescription(String name, String description);
	
	// url used -> http://localhost:8080/getProductsByNameOrDescriotion?name=RemoteCar&description=belongs to toys
	public List<Product> findByNameOrDescription(String name, String description);
	
	
	public Product findDistinctByName(String name);
	
	// url used -> http://localhost:8080/getProductsGreaterThanPrice?price=500
	public List<Product> findByPriceGreaterThan(BigDecimal price);
	
	// url used -> http://localhost:8080/getProductsLessThanPrice?price=700
	public List<Product> findByPriceLessThan(BigDecimal price);
	
	// url used -> http://localhost:8080/getProductsContainingSameName?name=RemoteCar
	public List<Product> findByNameContaining(String name);
	
	// url used -> http://localhost:8080/getProductsBetweenPrice?startPrice=100&endPrice=700
	public List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);
	
	// Not working
	public List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);
	
	// url used -> http://localhost:8080/getProductsInListOfNames?name=RemoteCar,JCB
	public List<Product> findByNameIn(List<String> names);
	
	public List<Product> findByOrderByPrice();
	
	public List<Product> findFirst2ByOrderByPrice();
	
	
	///////////////////////// Index Based JPQL Query Starts/////////////////////////
	
	@Query("select p from Product p where p.name = ?1 or p.description = ?2")
	public List<Product> findByNameOrDescriptionIndexParam(String name, String description);
	
	
	///////////////////////Ends///////////////////////////////////////
	

///////////////////////// Index Based Native SQL Query Starts/////////////////////////
	
	// url used -> http://localhost:8080/getProductNameOrDescriptionSQLQuery?name=RemoteCar&description=belongs to toys
	@Query(value = "select * from products where name = ?1 or description = ?2", nativeQuery = true)
	List<Product> findByNameOrDescriptionSQLIndexParam(String name, String description);
	
	/////////////////////////////Index Based Native SQL Query Ends///////////////////////////
	
	///////////////////////////////////Name Based Native SQL Query///////////////////////////
	
	@Query(value = "select * from products where name = :name or description = :description", nativeQuery = true)
	List<Product> findByNameOrDescriptionNamedSQLQuery(@Param("name") String name, @Param("description") String description);
	
}
