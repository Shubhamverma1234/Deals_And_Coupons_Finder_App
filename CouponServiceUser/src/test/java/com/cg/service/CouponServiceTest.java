package com.cg.service;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.exception.CouponAlreadyExistsException;

import com.cg.model.Coupons;

import com.cg.repository.CouponsRepository;



@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CouponServiceTest {
	
	@Mock
	private CouponsRepository dr;
	
	@InjectMocks
	private CouponsServiceImpl dsl;

	@Test
	public void TestAddAgency() throws FileAlreadyExistsException, CouponAlreadyExistsException {
	Coupons a1= new Coupons(101,"Accounts","Chennai");//user input
	
	when(dr.save(any())).thenReturn(a1);
	dsl.addCoupon(a1);//data is save in database
	verify(dr,times(1)).save(any());
		
	}
	
	@Test
	public void testGetAllAgencys()
	{
    	Coupons	 a1 = new Coupons(10,"Account","bhilai");//  user Input 
		Coupons a2 = new Coupons(11,"orgnization","mumbai");//  user Input 
		Coupons a3 = new Coupons(12,"sales","banglore");//  user Input 
		dr.save(a1);//data save in database
		dr.save(a2);
		dr.save(a3);
		List<Coupons>dList = new ArrayList<>();//creating list object
		dList.add(a1);
		dList.add(a2);
		dList.add(a3);
		when(dr.findAll()).thenReturn(dList);
		List<Coupons> dList1 = dsl.getAllCoupons();
		assertEquals(dList,dList1);
		verify(dr,times(1)).save(a1);
		verify(dr,times(1)).findAll();
		
	}
}
