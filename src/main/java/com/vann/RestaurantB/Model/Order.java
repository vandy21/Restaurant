package com.vann.RestaurantB.Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table (name="Order")
@Component
public class Order {
	private static final DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static final DateFormat dtf = new SimpleDateFormat("HH:mm:ss");
	private static final long SerialVersionUID=1l;
	@Id
	private String orderId;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "billingId")
	BillingAddress billingAddress;

//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name = "ShippingId")
//	ShippingAddress shippingAddress;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "payId")
	Pay pay;

	@OneToOne
	@JoinColumn(name = "userId")
	User user;
	private double grandTotal;
	
    @OneToMany(mappedBy="order")
    List<OrderItem> OrderItem;
    
    private String orderdate;
    private String ordertime;
    
	public Order() {
		Date date = new Date();
		orderdate=sdf.format(date);
		Calendar cal = Calendar.getInstance();
		Date date1 = new Date();
		ordertime=dtf.format(date1);
		this.orderId = UUID.randomUUID().toString().substring(30).toUpperCase();
		
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

//	public ShippingAddress getShippingAddress() {
//		return shippingAddress;
//	}
//
//	public void setShippingAddress(ShippingAddress shippingAddress) {
//		this.shippingAddress = shippingAddress;
//	}

	public Pay getPay() {
		return pay;
	}

	public void setPay(Pay pay) {
		this.pay = pay;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public List<OrderItem> getOrderItem() {
		return OrderItem;
	}

	public void setOrderItem(List<OrderItem> orderItem) {
		OrderItem = orderItem;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	
}