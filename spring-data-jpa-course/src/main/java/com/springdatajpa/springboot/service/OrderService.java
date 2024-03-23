package com.springdatajpa.springboot.service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdatajpa.springboot.entity.Order;
import com.springdatajpa.springboot.entity.OrderItem;
import com.springdatajpa.springboot.entity.Product;
import com.springdatajpa.springboot.repository.OrderRepository;
import com.springdatajpa.springboot.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {
	
	// unidirectional one to one mapping
	
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public void saveOrder(Order order) {
		orderRepository.save(order);
	}
	
	public void updateOrder(Long id, Order order) {
		
		Order existingOrder = orderRepository.findById(id).get();
		
		existingOrder.setStatus(order.getStatus());
		
		
		existingOrder.getBillingAddress().setZipcode(order.getBillingAddress().getZipcode());
		
		orderRepository.save(existingOrder);
		
	}
	
	public void deleteById(Long id) {
		Order order = orderRepository.findById(id).get();
		
		if(order!=null) {
			orderRepository.deleteById(id);
		}
	}
	
	public Order retrieveOrderById(Long id) {
		return orderRepository.findById(id).get();
	}
	
	////////////////////////////// one to many unidirectional mapping //////////////////////////////
	
	 @Transactional
	public void saveOrderWithOrderItems(Order order) {
		
		
		Set<OrderItem> orderItems = order.getOrderItem();
		
		BigDecimal totalPrice = BigDecimal.ZERO;
		
		
		
		for (OrderItem orderItem : orderItems) {
			System.out.println("Product "+orderItem.getProduct());
			System.out.println("Product id"+orderItem.getProduct().getId());
			Product product = productRepository.findById(orderItem.getProduct().getId()).get();
			
			
			orderItem.setProduct(product);
			
			orderItem.setPrice(product.getPrice());
			
			orderItem.setImageurl(product.getImageUrl());
			totalPrice = totalPrice.add(product.getPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity())));
			
		}
		order.setTotalPrice(totalPrice);
		
		orderRepository.save(order);

	}
	 
	 public Order getOrderById(Long id) {
		 Order order = orderRepository.findById(id).get();
		 return order;
	 }
	 
	 public void deleteOrderById(Long id) {
		 orderRepository.deleteById(id);
	 }

}
