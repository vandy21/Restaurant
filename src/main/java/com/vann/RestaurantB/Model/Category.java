package com.vann.RestaurantB.Model;


import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table
@Component
public class Category {
	private static final long SerialVersionUID=1l;
	@Id
	private String categoryId;
	private String categoryName;
	
	@OneToMany(mappedBy="category")
	List<Product> product;

	public Category() {
		
		this.categoryId = "CAT"+UUID.randomUUID().toString().substring(30).toUpperCase();

	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
	

}
