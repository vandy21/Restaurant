package com.vann.RestaurantB.Dao;

import java.util.List;

import com.vann.RestaurantB.Model.User;

public interface UserDao {
	public boolean saveupdate(User user);
	public boolean delete(String userId);
	public User get(String userId);
	public List<User> list();
	public User getUserEmail(String email);
	public User isValidated(String userEmail , String userPassword);
	

}
