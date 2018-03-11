package com.vann.RestaurantB.Dao;

import java.util.List;

import com.vann.RestaurantB.Model.Category;



public interface CategoryDao {
	public boolean saveupdate(Category category);
	public boolean delete(String categoryId);
	public Category get(String categoryId);
	public List<Category> list();
	

}
