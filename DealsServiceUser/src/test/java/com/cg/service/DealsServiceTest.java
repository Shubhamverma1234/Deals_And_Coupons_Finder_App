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

import com.cg.exception.DealsAlreadyExistsException;

import com.cg.model.Deals;

import com.cg.repository.DealsRepository;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DealsServiceTest {
	
	@Mock
	private DealsRepository dr;
	
	@InjectMocks
	private DealsServiceImpl dsl;

	@Test
	public void TestAddAgency() throws FileAlreadyExistsException, DealsAlreadyExistsException {
	Deals a1= new Deals(101,"Accounts","Chennai");//user input
	
	when(dr.save(any())).thenReturn(a1);
	dsl.addDeals(a1);//data is save in database
	verify(dr,times(1)).save(any());
		
	}
	
	@Test
	public void testGetAllAgencys()
	{
    	Deals	 a1 = new Deals(10,"Account","bhilai");//  user Input 
		Deals a2 = new Deals(11,"orgnization","mumbai");//  user Input 
		Deals a3 = new Deals(12,"sales","banglore");//  user Input 
		dr.save(a1);//data save in database
		dr.save(a2);
		dr.save(a3);
		List<Deals>dList = new ArrayList<>();//creating list object
		dList.add(a1);
		dList.add(a2);
		dList.add(a3);
		when(dr.findAll()).thenReturn(dList);
		List<Deals> dList1 = dsl.getAllDeals();
		assertEquals(dList,dList1);
		verify(dr,times(1)).save(a1);
		verify(dr,times(1)).findAll();
		
	}
}
