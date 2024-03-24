package com.springdatajpa.springboot.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER, mappedBy = "roles")
	private Set<User> user;
		
	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Role(Long id, String name, Set<User> user) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", user=" + user + "]";
	}
	
	

}
