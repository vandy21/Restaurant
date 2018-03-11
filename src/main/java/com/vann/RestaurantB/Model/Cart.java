package com.vann.RestaurantB.Model;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class Cart {
	private static final long SrialVersionUUID = 1l;

	@Id
    private String cartId;	
	private  int totalItem=0;
	private double  grandTotal=0.0;
	
	@OneToMany(mappedBy="cart")
	List<CartItem> cartItem;
			
	public Cart() {
		
		this.cartId = "CA"+UUID.randomUUID().toString().substring(30).toUpperCase();
		}



	public String getCartId() {
		return cartId;
	}



	public void setCartId(String cartId) {
		this.cartId = cartId;
	}



	public int getTotalItem() {
		return totalItem;
	}



	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}



	public double getGrandTotal() {
		return grandTotal;
	}



	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}



	public List<CartItem> getCartItem() {
		return cartItem;
	}



	public void setCartItem(List<CartItem> cartItem) {
		this.cartItem = cartItem;
	}
	

}
