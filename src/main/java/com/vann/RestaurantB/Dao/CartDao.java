package com.vann.RestaurantB.Dao;

import java.util.List;

import com.vann.RestaurantB.Model.Cart;

public interface CartDao {
	public boolean saveupdate(Cart card);

	public boolean delete(String cartId);

	public Cart get(String cartId);
	public List<Cart> list();


}
