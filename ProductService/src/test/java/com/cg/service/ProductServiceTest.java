package com.cg.service;

import static org.junit.jupiter.api.Assertions.*;
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

import com.cg.exception.ProductAlreadyExistsException;
import com.cg.model.Product;
import com.cg.repository.ProductRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
	
	@Mock
	private ProductRepository dr;
	
	@InjectMocks
	private ProductServiceImpl dsl;

	@Test
	public void TestAddAgency() throws FileAlreadyExistsException, ProductAlreadyExistsException {
	Product a1= new Product(101,"Accounts","Chennai");//user input
	
	when(dr.save(any())).thenReturn(a1);
	dsl.addProducts(a1);//data is save in database
	verify(dr,times(1)).save(any());
		
	}
	
	@Test
	public void testGetAllAgencys()
	{
    	Product	 a1 = new Product(10,"Account","bhilai");//  user Input 
		Product a2 = new Product(11,"orgnization","mumbai");//  user Input 
		Product a3 = new Product(12,"sales","banglore");//  user Input 
		dr.save(a1);//data save in database
		dr.save(a2);
		dr.save(a3);
		List<Product>dList = new ArrayList<>();//creating list object
		dList.add(a1);
		dList.add(a2);
		dList.add(a3);
		when(dr.findAll()).thenReturn(dList);
		List<Product> dList1 = dsl.getAllProducts();
		assertEquals(dList,dList1);
		verify(dr,times(1)).save(a1);
		verify(dr,times(1)).findAll();
		
	}
}
