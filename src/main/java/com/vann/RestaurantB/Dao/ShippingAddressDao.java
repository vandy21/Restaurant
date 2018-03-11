package com.vann.RestaurantB.Dao;

import java.util.List;

import com.vann.RestaurantB.Model.ShippingAddress;

public interface ShippingAddressDao {
	public boolean saveupdate( ShippingAddress shippingAddress);

	public boolean delete(String shippingId);

	public ShippingAddress get(String shippingId);
	public List<ShippingAddress> getlistbyU_Id(String userId);
	public List<ShippingAddress> list();

}
