package com.springdatajpa.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdatajpa.springboot.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
