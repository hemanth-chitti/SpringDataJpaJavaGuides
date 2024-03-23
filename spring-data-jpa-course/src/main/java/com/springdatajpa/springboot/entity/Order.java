package com.springdatajpa.springboot.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name  = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String orderTrackingNumber;
	private int quantity;
	private BigDecimal totalPrice;
	private String status;
	
	@CreationTimestamp
	private LocalDateTime dateCreated;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
	// join column for one to one unidirectional mapping
	private Address billingAddress;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	private Set<OrderItem> orderItem = new HashSet<OrderItem>();

	
	public Order() {
		// TODO Auto-generated constructor stub
	}


	public Order(long id, String orderTrackingNumber, int quantity, BigDecimal totalPrice, String status,
			LocalDateTime dateCreated, LocalDateTime lastUpdatedDate, Address billingAddress,
			Set<OrderItem> orderItem) {
		super();
		this.id = id;
		this.orderTrackingNumber = orderTrackingNumber;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.status = status;
		this.dateCreated = dateCreated;
		this.lastUpdatedDate = lastUpdatedDate;
		this.billingAddress = billingAddress;
		this.orderItem = orderItem;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getOrderTrackingNumber() {
		return orderTrackingNumber;
	}


	public void setOrderTrackingNumber(String orderTrackingNumber) {
		this.orderTrackingNumber = orderTrackingNumber;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public BigDecimal getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public LocalDateTime getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}


	public LocalDateTime getLastUpdatedDate() {
		return lastUpdatedDate;
	}


	public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}


	public Address getBillingAddress() {
		return billingAddress;
	}


	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}


	public Set<OrderItem> getOrderItem() {
		return orderItem;
	}


	public void setOrderItem(Set<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}


	@Override
	public String toString() {
		return "Order [id=" + id + ", orderTrackingNumber=" + orderTrackingNumber + ", quantity=" + quantity
				+ ", totalPrice=" + totalPrice + ", status=" + status + ", dateCreated=" + dateCreated
				+ ", lastUpdatedDate=" + lastUpdatedDate + ", billingAddress=" + billingAddress + ", orderItem="
				+ orderItem + "]";
	}
	
	
}
