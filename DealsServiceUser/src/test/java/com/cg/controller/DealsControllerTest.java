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


import com.cg.model.Deals;

import com.cg.service.DealsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@ExtendWith(MockitoExtension.class)
public class DealsControllerTest {
     
	@Autowired
	private MockMvc mockMvc; 
	
	@Mock
	private DealsService aptService;
	private Deals apt; 
	private List<Deals> agenList;
	
	@InjectMocks
	private DealsServiceController dc;
	
	@BeforeEach
	public void setUp()
	{
		apt = new Deals(1,"Finance","Pune");
		mockMvc = MockMvcBuilders.standaloneSetup(dc).build();
	}
	
	

	
	@Test
	public void getAgencyComplexController() throws Exception {
	when(aptService.getAllDeals()).thenReturn(agenList);
	mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/deals")
	.contentType(MediaType.APPLICATION_JSON)
	.content(asJSONString(apt)))
	.andDo(MockMvcResultHandlers.print());
	verify(aptService,times(1)).getAllDeals();
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
