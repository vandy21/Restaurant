package com.vann.RestaurantB.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class OrderItem {
private static final long SerialVersionUID=1l;
	
	
	@Id
	private String orderItemId;
	
//	@ManyToOne
//	@JoinColumn(name="orderId")
//	private Order order;
//	
	private String productId;

	public OrderItem() {
		
		this.orderItemId = "OI"+UUID.randomUUID().toString().substring(30).toUpperCase();

	}

	public String getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}

//	public Order getOrder() {
//		return order;
//	}
//
//	public void setOrder(Order order) {
//		this.order = order;
//	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	


}
