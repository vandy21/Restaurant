package com.vann.RestaurantB.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Authentication {
	private static final long SrialVersionUUID = 1l;
	@Id
private String roleId;
private String roleName ="ROLE_USER";
private String userName;
public Authentication() {
	
	this.roleId = "AUT"+UUID.randomUUID().toString().substring(30).toUpperCase();
}
public String getRoleId() {
	return roleId;
}
public void setRoleId(String roleId) {
	this.roleId = roleId;
}
public String getRoleName() {
	return roleName;
}
public void setRoleName(String roleName) {
	this.roleName = roleName;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}



}
