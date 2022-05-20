package com.cg.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


// Model class or Java Bean or POJO

@Document(collection="producttable")
public class Product {
	
	//Attributes
	@Id  // primary key
	private int productno;
	private String pname;
	private String pdetails;
	
	//default constructor
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	//parameterized constructor
	public Product(int productno, String pname, String pdetails) {
		super();
		this.productno = productno;
		this.pname = pname;
		this.pdetails = pdetails;
	}
	//setters and getters
	public int getProductno() {
		return productno;
	}

	public void setProductno(int productno) {
		this.productno = productno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPdetails() {
		return pdetails;
	}

	public void setPdetails(String pdetails) {
		this.pdetails = pdetails;
	}
	 

	
	
	
	
	
	
}

