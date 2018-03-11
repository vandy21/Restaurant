package com.vann.RestaurantB.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Pay {
private static final long SerialVersionUID=1l;
	
	@Id
	private String payId;
	private String payMay;
	private String payStatus;
	
	public Pay() {
		this.payId = "PAY"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	public String getPayId() {
		return payId;
	}

	public void setPayId(String payId) {
		this.payId = payId;
	}

	public String getPayMay() {
		return payMay;
	}

	public void setPayMay(String payMay) {
		this.payMay = payMay;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

		
	
	
	
}