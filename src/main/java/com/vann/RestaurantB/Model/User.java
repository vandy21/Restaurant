package com.vann.RestaurantB.Model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table
@Component
public class User {
	private static final long SerialVersionUID=1l;
	@Id
    private String userId;
	private String userName;
	private String userEmail;
	private String userPassword;
	private String userMobileNo;
	private String userAddress;
	
	private String role_name = "ROLE_USER";

	
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="billingId")
//	private BillingAddress billingAddress;
//	
//	@OneToOne
//	@JoinColumn(name="cartId")
//	private Cart cart; 
//	
	public User() {
		super();
		this.userId = "US"+UUID.randomUUID().toString().substring(30).toUpperCase();

	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public String getUserMobileNo() {
		return userMobileNo;
	}


	public void setUserMobileNo(String userMobileNo) {
		this.userMobileNo = userMobileNo;
	}


	public String getUserAddress() {
		return userAddress;
	}


	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}


	public String getRole_name() {
		return role_name;
	}


	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}


//	public BillingAddress getBillingAddress() {
//		return billingAddress;
//	}
//
//
//	public void setBillingAddress(BillingAddress billingAddress) {
//		this.billingAddress = billingAddress;
//	}
//
//
//	public Cart getCart() {
//		return cart;
//	}
//
//
//	public void setCart(Cart cart) {
//		this.cart = cart;
//	}
	
	
}
