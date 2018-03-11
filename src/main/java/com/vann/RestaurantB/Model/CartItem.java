package com.vann.RestaurantB.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class CartItem {
	private static final long SrialVersionUUID = 1l;

	@Id
	private String cartItemId;
	private float price;
	
	@OneToOne
	@JoinColumn(name="productId")
	private Product product;
		
	@ManyToOne
	@JoinColumn(name="cartId")	
	Cart cart;

	public CartItem() {
		
		this.cartItemId = "CI"+UUID.randomUUID().toString().substring(30).toUpperCase();
		
	}

	public String getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(String cartItemId) {
		this.cartItemId = cartItemId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	
	


}
