package com.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.app.dto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "customer_id", referencedColumnName = "customerId")
	private Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "carts_product", joinColumns = @JoinColumn(name="cart_id", referencedColumnName = "cartId"))
//	private List<Product> products;
	private List<ProductDto> products = new ArrayList<>();

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<ProductDto> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDto> products) {
		this.products = products;
	}

	public Cart(Integer cartId, Customer customer, List<ProductDto> products) {
		super();
		this.cartId = cartId;
		this.customer = customer;
		this.products = products;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
	

}
