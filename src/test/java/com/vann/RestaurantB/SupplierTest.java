package com.vann.RestaurantB;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vann.RestaurantB.Dao.SupplierDao;
import com.vann.RestaurantB.Model.Supplier;

public class SupplierTest {
	public static void main(String[] args)
	{
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.vann.*");
	context.refresh();
	System.out.println(1);
	SupplierDao supplierDao =(SupplierDao)context.getBean("supplierDao");
	Supplier supplier =(Supplier)context.getBean("supplier");
	supplier.setSupplierId("sup123");
	supplier.setSupplierName("vandana");
	supplier.setSupplierAddress("delhi");
	supplier.setSupplierMobileNo("99165");
	supplier.setSupplierEmail("van@gmail.com");
	
	if(supplierDao.saveupdate(supplier)==true)
	{
		System.out.println("supplier  is saved");
	}
	else{
		System.out.println("soryy for supplier save");
	}
//	System.out.println("my supplier save connection is right !");
//		if(supplierDao.delete("sup123")==true)
//	{
//	System.out.println("supplier delete is working");
//	}
//		else{
//		System.out.println("sorry for supplier is delete ");
//	}
//			System.out.println("my supplier delete connection is right !");

	
	//***************************GET ***********************************//
	supplier=supplierDao.get("sup123");
	if(supplier==null){
		System.out.println("sorry no data found ");
		
	}
	else{
	System.out.println(supplier.getSupplierId());
	System.out.println(supplier.getSupplierName());
	System.out.println(supplier.getSupplierAddress());
	System.out.println(supplier.getSupplierEmail());
	System.out.println(supplier.getSupplierMobileNo());
	

	}
	//***************************LIST ***********************************//

	List<Supplier> list=supplierDao.list();
	for(Supplier su:list)
	{
		System.out.println(su.getSupplierId());
		System.out.println(su.getSupplierName());
		System.out.println(su.getSupplierAddress());
		System.out.println(su.getSupplierEmail());
		System.out.println(su.getSupplierMobileNo());
	}

	}

	

}
