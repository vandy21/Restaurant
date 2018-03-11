package com.vann.RestaurantB;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vann.RestaurantB.Dao.UserDao;
import com.vann.RestaurantB.Model.User;

public class UserTest {
	public static void main(String[] args)
	{
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.vann.*");
	context.refresh();
	System.out.println(1);
	UserDao userDao =(UserDao)context.getBean("userDao");
	User user =(User)context.getBean("user");
//	Cart cart=(Cart)context.getBean("cart");
	user.setUserId("u100");
	user.setUserName("vandy");
	user.setUserAddress("bangalore");
	user.setUserEmail("van@gmail.com");
	user.setUserMobileNo("99165");
	user.setUserPassword("Vand");
//	user.setCart(cart);
	
	if(userDao.saveupdate(user)==true)
	{
		System.out.println("user  is saved");
	}
	else{
		System.out.println("soryy for user save");
	}
	System.out.println("my user save connection is right !");
		if(userDao.delete("u100")==true)
	{
	System.out.println("user delete is working");
	}
		else{
		System.out.println("sorry for user is delete ");
	}
			System.out.println("my user delete connection is right !");

			
	
	
	

}}
