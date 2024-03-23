package com.springdatajpa.springboot.pagingandsortingservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springdatajpa.springboot.entity.Product;
import com.springdatajpa.springboot.repository.ProductRepository;

@Service
public class PagingAndSortingService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getPagingRecords(){
		
		int pageNumber = 0;
		int pageSize = 3;
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		
		Page<Product> page = productRepository.findAll(pageable);
		
		// Total pages
		System.out.println("Total pages "+page.getTotalPages());
		
		// TotalElements
		System.out.println("TotalElements "+page.getTotalElements());
		
		// NumberOfElements
		System.out.println("NumberOfElements "+page.getNumberOfElements());
		
		// Page Number
		System.out.println("Page Number "+page.getNumber());
		
		// Is First Page
		System.out.println("Is First Page Number "+page.isFirst());
		
		// Is Last Page
		System.out.println("Is Last Page Number "+page.isLast());
		
		// Page Size
		System.out.println(" Page Size"+page.getSize());
		
		return page.getContent();

	}
	
	public List<Product> getProductsSortByOneFiled(){
		// Approach1 directly consume ascending or descending APIs
		/*
		String sortBy = "price";
		
		List<Product> products = productRepository.findAll(Sort.by(sortBy).ascending());
		
		 */
		
		// Aprroach 2 make the direction (ASc or DESC) which the decision comes from user
		
		String sortBy = "price";
		String sortDir = "desc";
		
		// checking whether sortDir is asc or desc according to that creating a sort object below.
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(sortBy).ascending(): 
			Sort.by(sortBy).descending();
		
		
		List<Product> products  = productRepository.findAll(sort);
		
		return products;
	}
	
	
	public List<Product> getProductsSortedBMultipleFields(){
		
		
		String sortByName = "name";
		String sortByPrice = "price";
		String sortDir = "desc";
		
		Sort sortingByName = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortByName).ascending() :
								Sort.by(sortByName).descending();
		
		Sort sortingByDescription = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(sortByPrice).ascending():
								Sort.by(sortByPrice).descending();
		
		Sort groupedSort = sortingByName.and(sortingByDescription);
		
		List<Product> products = productRepository.findAll(groupedSort);
		
		return products;
	}
	
	public List<Product> pagingAndSortingTogether(){
		
		int pageNo = 0;
		int pageSize = 3;
		
		String sortBy ="price";
		String sortDir = "desc";
		
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending():
					Sort.by(sortBy).descending();
		
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		
		Page<Product> page = productRepository.findAll(pageable);
		
		
		// Total pages
		System.out.println("Total pages "+page.getTotalPages());
		
		// TotalElements
		System.out.println("TotalElements "+page.getTotalElements());
		
		// NumberOfElements
		System.out.println("NumberOfElements "+page.getNumberOfElements());
		
		// Page Number
		System.out.println("Page Number "+page.getNumber());
		
		// Is First Page
		System.out.println("Is First Page Number "+page.isFirst());
		
		// Is Last Page
		System.out.println("Is Last Page Number "+page.isLast());
		
		// Page Size
		System.out.println(" Page Size"+page.getSize());
		
		return page.getContent();
	}

}
