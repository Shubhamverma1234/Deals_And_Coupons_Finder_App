package com.cg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class Users {

	//Attributes
	@Id
	private String userName;
	private String passWord;
	
	
	//Default Constructor
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Parameterized Constructor
	public Users(String id, String userName, String passWord) {
		super();

		this.userName = userName;
		this.passWord = passWord;
	}
	


	//Setters and Getters
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}	


	//ToString 
	@Override
	public String toString() {
		return "User [userName=" + userName + ", passWord=" + passWord + "]";
	}
	
	
}
