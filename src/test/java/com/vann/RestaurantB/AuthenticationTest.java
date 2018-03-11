package com.vann.RestaurantB;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vann.RestaurantB.Dao.AuthenticationDao;
import com.vann.RestaurantB.Model.Authentication;

public class AuthenticationTest {
	public static void main(String[] args)
	{
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.vann.*");
	context.refresh();
	System.out.println(1);
	AuthenticationDao authenticationDao =(AuthenticationDao)context.getBean("authenticationDao");
	Authentication au =(Authentication)context.getBean("authentication");
au.setRoleName("admin");
au.setUserName("abcd");

if(authenticationDao.saveupdate(au)==true){
	System.out.println("saved");
	
}
else{
	System.out.println(" not saved");
	
}

	}


}
