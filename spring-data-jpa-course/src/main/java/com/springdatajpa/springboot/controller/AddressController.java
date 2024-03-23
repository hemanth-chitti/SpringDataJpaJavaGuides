package com.springdatajpa.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springdatajpa.springboot.entity.Address;
import com.springdatajpa.springboot.service.AddressService;

@RestController
public class AddressController {
	
	//Bidirectional one to one mapping
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/saveAdressWithOrder")
	public void saveAddressWithOrderBidirectional(@RequestBody Address address) {
		addressService.saveAddressWithOrder(address);
	}
	
	@PutMapping("/updateAddressWithOrder")
	public void updateAddressOrderBidirectional(@RequestParam Long id, @RequestBody Address address) {
		addressService.updateAddressWithOrder(id, address);
	}
	
	// not working fetching multiple instances of same id
	@GetMapping("/getAddressWthOrder")
	public Address getAddressWithOrderBidirectiona(@RequestParam Long id) {
		System.out.println("id "+id);
		return addressService.retrieveAddressById(id);
	}
	
	@DeleteMapping("/deleteAddressWithOrder")
	public void deleteAddressWithOrder(@RequestParam Long id) {
		addressService.deleteAddressById(id);
	}

}
