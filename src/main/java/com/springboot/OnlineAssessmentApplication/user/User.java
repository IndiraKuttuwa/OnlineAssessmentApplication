package com.springboot.OnlineAssessmentApplication.user;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User implements Comparable<User>{
	
	@Id
	private String email;
	
	
	private String password;
	
	private String firstName;
	private String lastName;
	private String userType;
	
	public User()
	{
		
	}
	public User(String email, String password, String firstName, String lastName, String userType) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userType = userType;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return this.getFirstName().compareTo(o.getFirstName());
	}

}
