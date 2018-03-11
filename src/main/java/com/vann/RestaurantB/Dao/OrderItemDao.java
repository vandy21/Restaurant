package com.vann.RestaurantB.Dao;

import java.util.List;

import com.vann.RestaurantB.Model.OrderItem;

public interface OrderItemDao {
	public boolean saveupdate(OrderItem orderItem);

	public boolean delete(String orderItemId);

	public OrderItem get(String orderItemId);
	public List<OrderItem> list();


}
