package com.springdatajpa.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdatajpa.springboot.entity.Address;
import com.springdatajpa.springboot.entity.Order;
import com.springdatajpa.springboot.repository.AddressRepository;
import com.springdatajpa.springboot.repository.OrderRepository;

@Service
public class AddressService {
	
	// Bidirectional one to one mapping
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	// Bidirectional one to one mapping
	
	public void saveAddressWithOrder(Address address) {
		
		addressRepository.save(address);
	}
	
	public void updateAddressWithOrder(Long id, Address address) {
		
		Address existingAddress = addressRepository.findById(id).get();
		
		existingAddress.setZipcode(address.getZipcode());
		
		existingAddress.getOrder().setStatus(address.getOrder().getStatus());
		
		addressRepository.save(existingAddress);
	}
	
	// not working fetching multiple instances of same id
	public Address retrieveAddressById(Long id) {
		Address address = addressRepository.findById(id).get();
		System.out.println("Address id "+address.getId());
		
		return address;
	}

	public void deleteAddressById(Long id) {
		Address address = addressRepository.findById(id).get();
		
		if(address!=null) {
			addressRepository.deleteById(id);
		}
	}
	
}
