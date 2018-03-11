package com.vann.RestaurantB.Dao;

import java.util.List;

import com.vann.RestaurantB.Model.Supplier;

public interface SupplierDao {
	public boolean saveupdate(Supplier sup);
	public boolean delete(String supplierId);
	public Supplier get(String supplierId);
	public List<Supplier> list();

}
