package com.vann.RestaurantB;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vann.RestaurantB.Dao.CategoryDao;
import com.vann.RestaurantB.Model.Category;

public class CategoryTest {
	public static void main(String[] args)
	{
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.vann.*");
	context.refresh();
	System.out.println(1);
	CategoryDao categoryDao =(CategoryDao)context.getBean("categoryDao");
	Category category =(Category)context.getBean("category");
	category.setCategoryId("cat666");
	category.setCategoryName("vandy");

	if(categoryDao.saveupdate(category)==true)
	{
		System.out.println("category is saved");
	}
	else{
		System.out.println("soryy for category save");
	}
	System.out.println("my category save connection is right !");
	//*************************SAVE UPDATE****************************************//
	category.setCategoryId("cat668");
	category.setCategoryName("vansh");
	if(categoryDao.saveupdate(category)==true)
	{
		System.out.println("category is saved");
	}
	else{
		System.out.println("soryy for category save");
	}
	System.out.println("my category save connection is right !");
	//***************************DELETE ***********************************//
		if(categoryDao.delete("cat668")==true)
		{
		System.out.println("category delete is working");
		}
		else{
			System.out.println("sorry for category is delete ");
		
			System.out.println("my category delete connection is right !");



	}
	//***************************GET ***********************************//
	category=categoryDao.get("cart667");
	if(category==null){
		System.out.println("sorry no data found ");
		
	}
	else{
	System.out.println(category.getCategoryId());
	System.out.println(category.getCategoryName());

	}
	//***************************LIST ***********************************//

	List<Category> list=categoryDao.list();
	for(Category c:list)
	{
		System.out.println(c.getCategoryId());
		System.out.println(c.getCategoryName());
	}

	}


}
