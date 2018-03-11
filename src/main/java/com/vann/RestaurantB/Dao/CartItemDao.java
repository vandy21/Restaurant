package com.vann.RestaurantB.Dao;

import java.util.List;

import com.vann.RestaurantB.Model.CartItem;

public interface CartItemDao {
	public boolean saveupdate(CartItem cartItem);
	public boolean delete(String cartItemId);
	public CartItem get(String cartItem);
	public List<CartItem> getlistbyproId(String productId);
	public List<CartItem> getlistbycartId(String cartId);	
	public List<CartItem> list();
	public CartItem getListall(String cartItemId,String productId);
	

}
