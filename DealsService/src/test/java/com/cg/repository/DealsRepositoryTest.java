package com.cg.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.model.Deals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class DealsRepositoryTest {

	@Autowired
	private DealsRepository dealRepo;
	
	@Test
	
	public void givenAgencyShouldReturnAgencyObject()
	{
		Deals d1 = new Deals(1,"Percentage discounts","Up to 20% off product Furlay Metal Recliner Chair Moulded Cushion (Coffee Bean)");//user input
		dealRepo.save(d1);//data is saved in database
		Deals d2= dealRepo.findById(d1.getDealno()).get();//fetching the data from database
		assertNotNull(d2);//it is returning the department object
		assertEquals(d1.getDname(),d2.getDname());
	}
	
	 @Test
	 public void getAllmustReturnAllAgencys()
	 {
		 Deals d3=new Deals(2,"Percentagediscounts","Up to 50% off product Amazon Brand - Solimo Alen 5 Seater Fabric LHS L Shape Sofa Set (Blue)");//user input
		 Deals d4=new Deals(3,"xx dollars off","$5 off product OnePlus 9 5G (Arctic Sky, 12GB RAM, 256GB Storage)");//user input
		 Deals d5=new Deals(4,"xx dollars off","$20 off product OnePlus 8 (Glacial Green 12GB RAM+256GB Storage)");//user input
		 dealRepo.save(d3);// saving in database
		 dealRepo.save(d4);//saving in data database
		 dealRepo.save(d5);
		 List<Deals>dealList = (List<Deals>)dealRepo.findAll();
		 assertEquals("xx dollars off",dealList.get(3).getDname());
		// assertNotNull(agenList.get(0));
		// assertEquals(3,agenList.size());
	 }
}