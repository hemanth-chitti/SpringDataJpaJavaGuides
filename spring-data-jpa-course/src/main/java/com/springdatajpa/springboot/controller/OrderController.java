package com.springdatajpa.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springdatajpa.springboot.entity.Order;
import com.springdatajpa.springboot.service.OrderService;

@RestController
public class OrderController {
	
	// unidirectional one to one mapping
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/saveOrder")
	public void saveOrderWithAddress(@RequestBody Order order) {
		orderService.saveOrder(order);
	}
	
	@PutMapping("/updateOrder")
	public void updateOrderWithAddress(@RequestParam Long id, @RequestBody Order order) {
		
		orderService.updateOrder(id, order);
		
	}
	
	@DeleteMapping("/deleteOrder")
	public void deleteOrderWithAddressById(@RequestParam Long id) {
		orderService.deleteById(id);
	}
	
	@GetMapping("/getOrder")
	public Order getOrderWithAddressById(@RequestParam Long id) {
		return orderService.retrieveOrderById(id);
	}
	
	///////////////// one to many bidirectional mapping ////////////////////////
	
	@PostMapping("/saveOrderWithOrderItems")
	public void saveOrderWithOrderItems(@RequestBody Order order) {
		orderService.saveOrderWithOrderItems(order);
	}
	
	@GetMapping("/getOrderById")
	public Order retrieveOrderById(@RequestParam Long id) {
		return orderService.getOrderById(id);
	}
	
	@DeleteMapping("/deleteOrderById")
	public void deleteOrderById(@RequestParam Long id) {
		orderService.deleteById(id);
	}

}
