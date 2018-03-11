package com.vann.RestaurantB;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vann.RestaurantB.Dao.ProductDao;
import com.vann.RestaurantB.Model.Product;

public class ProductTest {
	public static void main(String[] args)
	{
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.vann.*");
	context.refresh();
	System.out.println(1);
//	ProductDao productDao =(ProductDao)context.getBean("productDao");
	ProductDao productDao = (ProductDao)context.getBean("productDao");
	Product product =(Product)context.getBean("product");
	product.setProductId("pro123");
	product.setProductName("apple");
	product.setProductDescription("healthy");
	product.setProductCost(150);
	product.setProductQuantity("250");
	
	
	if(productDao.saveupdate(product)==true)
	{
		System.out.println("Product  is saved");
	}
	else{
		System.out.println("soryy for Product save");
	}
	System.out.println("my Product save connection is right !");
		if(productDao.delete("PRO123")==true)
	{
	System.out.println("Product delete is working");
	}
		else{
		System.out.println("sorry for Product is delete ");
	}
			System.out.println("my Product delete connection is right !");

	
	//***************************GET ***********************************//
	product=productDao.get("pro123");
	if(product==null){
		System.out.println("sorry no data found ");
		
	}
	else{
	System.out.println(product.getProductId());
	System.out.println(product.getProductName());
	System.out.println(product.getProductCost());
	System.out.println(product.getProductDescription());
	System.out.println(product.getProductQuantity());

	}
	//***************************LIST ***********************************//

	List<Product> list=productDao.list();
	for(Product pro:list)
	{
		System.out.println(pro.getProductId());
		System.out.println(pro.getProductName());
		System.out.println(pro.getProductCost());
		System.out.println(pro.getProductDescription());
		System.out.println(pro.getProductQuantity());
	}

	}


}
