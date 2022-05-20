package com.cg.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


// Model class or Java Bean or POJO

@Document(collection="dealstable")
public class Deals {
	
	//Attributes
	@Id  // primary key
	private int dealno;
	private String dname;
	private String ddetails;
	
	//default constructor
	public Deals() {
		super();
		// TODO Auto-generated constructor stub
	}
	//parameterized constructor
	public Deals(int dealno, String dname, String ddetails) {
		super();
		this.dealno = dealno;
		this.dname = dname;
		this.ddetails = ddetails;
	}
	//setters and getters
	public int getDealno() {
		return dealno;
	}
	public void setDealno(int dealno) {
		this.dealno = dealno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDdetails() {
		return ddetails;
	}
	public void setDdetails(String ddetails) {
		this.ddetails = ddetails;
	}
	 
}
