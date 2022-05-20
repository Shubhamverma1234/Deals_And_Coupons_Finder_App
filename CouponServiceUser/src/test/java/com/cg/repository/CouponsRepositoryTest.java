package com.cg.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.model.Coupons;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CouponsRepositoryTest {

	@Autowired
	private CouponsRepository coupRepo;
	
	@Test
	
	public void givenAgencyShouldReturnAgencyObject()
	{
		Coupons d1 = new Coupons(1,"Freeshippingcoupon","coupon code-SPECIAL20 applied on product OnePlus TV");//user input
		coupRepo.save(d1);//data is saved in database
		Coupons d2= coupRepo.findById(d1.getCouponno()).get();//fetching the data from database
		assertNotNull(d2);//it is returning the department object
		assertEquals(d1.getCname(),d2.getCname());
	}

	 @Test 
	 public void getAllmustReturnAllAgencys()
	 {
		 Coupons d3=new Coupons(2,"Free shipping coupon","coupon code-SPECIAL30 applied on product OnePlus phone ");//user input
		 Coupons d4=new Coupons(3,"Freegiftwithpurchase","coupon code-SPECIAL50 applied on product Dell Laptop");//user input
		 Coupons d5=new Coupons(4,"Free gift with purchase","coupon code-SPECIAL60 applied on product Samsung Galaxy Watch 3");//user input
		 coupRepo.save(d3);// saving in database
		 coupRepo.save(d4);//saving in data database
		 coupRepo.save(d5);
		 List<Coupons>agenList = (List<Coupons>)coupRepo.findAll();
		 assertEquals("Free gift with purchase",agenList.get(3).getCname());
		// assertNotNull(agenList.get(0));
		// assertEquals(3,agenList.size());
	 }
}