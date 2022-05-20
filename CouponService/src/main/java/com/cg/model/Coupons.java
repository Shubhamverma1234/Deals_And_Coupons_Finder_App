package com.cg.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


// Model class or Java Bean or POJO

@Document(collection="coupontable")
public class Coupons {
	
	//Attributes
	@Id  // primary key
	private int couponno;
	private String cname;
	private String cdetails;
	
	//default constructor
	public Coupons() {
		super();
		// TODO Auto-generated constructor stub
	}
	//parameterized constructor
	public Coupons(int couponno, String cname, String cdetails) {
		super();
		this.couponno = couponno;
		this.cname = cname;
		this.cdetails = cdetails;
	}
	//setters and getters
	public int getCouponno() {
		return couponno;
	}

	public void setCouponno(int couponno) {
		this.couponno = couponno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCdetails() {
		return cdetails;
	}

	public void setCdetails(String cdetails) {
		this.cdetails = cdetails;
	}
	
	
	
	
	


	

	
}
