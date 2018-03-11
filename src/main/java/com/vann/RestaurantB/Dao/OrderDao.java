package com.vann.RestaurantB.Dao;

import java.util.List;

import com.vann.RestaurantB.Model.Order;

public interface OrderDao {
	public boolean saveupdate(Order  order);

	public boolean delete(String orderId);

	public Order get(String orderId);
	public List<Order> list();


}
