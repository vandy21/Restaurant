package com.vann.RestaurantB.Dao;

import java.util.List;

import com.vann.RestaurantB.Model.Authentication;

public interface AuthenticationDao {
	public boolean saveupdate(Authentication authentication);
	

	public boolean delete(String roleId);

	public Authentication get(String roleId);
	public List<Authentication> list();


}
