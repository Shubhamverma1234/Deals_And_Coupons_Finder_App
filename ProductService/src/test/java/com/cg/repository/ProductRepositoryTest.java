package com.cg.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.model.Product;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ProductRepositoryTest {

	@Autowired
	private ProductRepository prodRepo;
	
	@Test
	
	public void givenAgencyShouldReturnAgencyObject()
	{
		Product d1 = new Product(1,"Samsung Galaxy Tab A8","coupon code-SPECIAL120 or Up to 20% off product");//user input
		prodRepo.save(d1);//data is saved in database
		Product d2= prodRepo.findById(d1.getProductno()).get();//fetching the data from database
		assertNotNull(d2);//it is returning the department object
		assertEquals(d1.getPname(),d2.getPname());
	}

	 @Test
	 public void getAllmustReturnAllAgencys()
	 {
		 Product d3=new Product(2,"2020 Apple iPad Air","coupon code-SPECIAL10 or Up to 30% off product");//user input
		 Product d4=new Product(3,"2019 Apple iPad Air","coupon code-SPECIAL10 or Up to 30% off product");//user input
		 Product d5=new Product(4,"2021 Apple iPad Pro","coupon code-SPECIAL20 or Up to 40% off product");//user input
		 prodRepo.save(d3);// saving in database
		 prodRepo.save(d4);//saving in data database
		 prodRepo.save(d5);
		 List<Product>agenList = (List<Product>)prodRepo.findAll();
		 assertEquals("2021 Apple iPad Pro",agenList.get(3).getPname());
		// assertNotNull(agenList.get(0));
		// assertEquals(3,agenList.size());
	 }
}