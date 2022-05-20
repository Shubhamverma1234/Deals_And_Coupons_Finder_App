package com.cg.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import java.util.List;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cg.model.Coupons;
import com.cg.service.CouponsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@ExtendWith(MockitoExtension.class)
public class CouponsControllerTest {
     
	@Autowired
	private MockMvc mockMvc; 
	
	@Mock
	private CouponsService aptService;
	private Coupons apt; 
	private List<Coupons> agenList;
	
	@InjectMocks
	private CouponsServiceController dc;
	
	@BeforeEach
	public void setUp()
	{
		apt = new Coupons(1,"Finance","Pune");
		mockMvc = MockMvcBuilders.standaloneSetup(dc).build();
	}
	
	

	
	@Test
	public void getAgencyComplexController() throws Exception {
	when(aptService.getAllCoupons()).thenReturn(agenList);
	mockMvc.perform(MockMvcRequestBuilders.get("/api/c2/coupons")
	.contentType(MediaType.APPLICATION_JSON)
	.content(asJSONString(apt)))
	.andDo(MockMvcResultHandlers.print());
	verify(aptService,times(1)).getAllCoupons();
	}



	public static String asJSONString(final Object obj)  {

		try {
	return new ObjectMapper().writeValueAsString(obj);
		}
		
	catch(Exception e) 
		{
		throw new RuntimeException(e);
		}
		
		
	}
}
