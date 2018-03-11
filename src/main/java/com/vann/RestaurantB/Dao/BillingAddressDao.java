package com.vann.RestaurantB.Dao;

import java.util.List;

import com.vann.RestaurantB.Model.BillingAddress;

public interface BillingAddressDao {
	public boolean saveupdate(BillingAddress BillingAdd);

	public boolean delete(String billingId);

	public BillingAddress get(String userId);
	public List<BillingAddress> list();
	


}
