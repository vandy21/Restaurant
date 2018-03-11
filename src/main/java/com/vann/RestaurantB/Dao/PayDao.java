package com.vann.RestaurantB.Dao;

import java.util.List;

import com.vann.RestaurantB.Model.Pay;

public interface PayDao {
	public boolean saveupdate(Pay pay);

	public boolean delete(String payId);

	public Pay get(String payId);
	public List<Pay> list();


}
