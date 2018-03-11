package com.vann.RestaurantB.Dao;

import java.util.List;

import com.vann.RestaurantB.Model.Product;

public interface ProductDao {
	
	public boolean saveupdate(Product pro);
	public boolean delete(String productId);
	public Product get(String productId);
   public List<Product> list();	
   public boolean delete2(Product product);
   public Product getCategory(String categoryId);


}
