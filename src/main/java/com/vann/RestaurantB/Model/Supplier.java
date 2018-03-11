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
public class Supplier {
	private static final long SerialVersionUID =1l;
	
@Id
private String supplierId;
private String supplierName;
private String supplierAddress;
private String supplierMobileNo;
private String supplierEmail;

@OneToMany(mappedBy ="supplier")
List<Product> product;

public Supplier() {
	
	this.supplierId = "SUP"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}

public String getSupplierId() {
	return supplierId;
}

public void setSupplierId(String supplierId) {
	this.supplierId = supplierId;
}

public String getSupplierName() {
	return supplierName;
}

public void setSupplierName(String supplierName) {
	this.supplierName = supplierName;
}

public String getSupplierAddress() {
	return supplierAddress;
}

public void setSupplierAddress(String supplierAddress) {
	this.supplierAddress = supplierAddress;
}

public String getSupplierMobileNo() {
	return supplierMobileNo;
}

public void setSupplierMobileNo(String supplierMobileNo) {
	this.supplierMobileNo = supplierMobileNo;
}

public String getSupplierEmail() {
	return supplierEmail;
}

public void setSupplierEmail(String supplierEmail) {
	this.supplierEmail = supplierEmail;
}

public List<Product> getProduct() {
	return product;
}

public void setProduct(List<Product> product) {
	this.product = product;
}

	

}
