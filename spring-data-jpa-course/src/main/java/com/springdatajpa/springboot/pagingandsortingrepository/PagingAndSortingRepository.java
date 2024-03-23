package com.springdatajpa.springboot.pagingandsortingrepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdatajpa.springboot.entity.Product;
import com.springdatajpa.springboot.pagingandsortingservice.PagingAndSortingService;

@RestController
public class PagingAndSortingRepository {
	
	@Autowired
	private PagingAndSortingService pagingAndSortingService;
	
	
	@GetMapping("/FirstPagingData")
	public List<Product> retrievePagingRecords(){
		
		
		return pagingAndSortingService.getPagingRecords();
	}
	
	@GetMapping("/sortingBySingleField")
	public List<Product> retrieveSortingBySinglEField(){
		
		
		return pagingAndSortingService.getProductsSortByOneFiled();
	}
	
	@GetMapping("/sortingByMultipleFields")
	public List<Product> retrieveSortingByMultiplelEFields(){
		
		
		return pagingAndSortingService.getProductsSortedBMultipleFields();
	}
	
	@GetMapping("/pagingAndSortingTogether")
	public List<Product> retrieveProductsPagingAndSortingTogether(){
		
		
		return pagingAndSortingService.pagingAndSortingTogether();
	}

}
