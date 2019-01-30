package com.usel.app.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.usel.app.model.Purchase;
import com.usel.app.service.PurchaseService;
import com.usel.app.service.exception.ServiceException;

@RunWith(SpringRunner.class)
public class PurchaseControllerTest {
	
	@InjectMocks
	PurchaseController purchaseController;

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
    MockMvc mockMvc;
	
	@MockBean
	PurchaseService purchaseService;
	
	Purchase purchase;
	List<Purchase> purchases;
	String purchaseId;
	int fakePO = -1;
	
	@Before
    public void setUp() {
		mockMvc = standaloneSetup(purchaseController).build();
        this.purchase = new Purchase();
        purchase.setFinalPoNumber("AP 2296 - 0450");
        purchases = new ArrayList<Purchase>();
    }
	
	@Test
	public void testGetAllSuccess() throws Exception {
		this.purchases.add(this.purchase);
		this.purchases.add(this.purchase);
		when(purchaseService.findAll()).thenReturn(purchases);

		mockMvc.perform(get("/purchases"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(jsonPath("$", hasSize(2)));
		
		verify(purchaseService, times(1)).findAll();
		verifyNoMoreInteractions(purchaseService);
	}
	
	@Test
	public void getAll_ShouldReturnStatusNoContentWhenPurchaseListEmpty() throws Exception {
		when(purchaseService.findAll()).thenReturn(purchases);
		
		mockMvc.perform(get("/purchases"))
			.andExpect(status().isNoContent());
	}
	
	@Test
	public void getAll_ShouldReturnStatusServiceTemporarilyUnavailableWhenPurchaseServiceFailed() throws Exception {
		when(purchaseService.findAll()).thenThrow(new ServiceException("Problem with DB connection"));
		
		mockMvc.perform(get("/purchases"))
		   .andExpect(status().is(503));
	}
	
	@Test
	public void testCreatePurchaseSuccess() throws Exception {
		
		when(purchaseService.exist(fakePO)).thenReturn(false); 
        when(purchaseService.create(purchase)).thenReturn(purchase); 
        
        mockMvc.perform(post("/purchases")                  
        		.contentType(MediaType.APPLICATION_JSON) 
        		.content(Utils.asJsonString(purchase)))
        		.andExpect(status().isCreated())  
				.andExpect(header().string("location", containsString("http://localhost/purchases/" + purchase.getPo())));
	
		verify(purchaseService, times(1)).exist(purchase.getPo()); 
		verify(purchaseService, times(1)).create(purchase); 
	}
	
	@Test
	public void create_ShouldReturnStatusConflictWhenPurchaseExists() throws Exception {
		when(purchaseService.exist(purchase.getPo())).thenReturn(true);
		mockMvc.perform(post("/purchases")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Utils.asJsonString(purchase)))	
				.andExpect(status().isConflict());
	}
	
	@Test
	public void createShouldReturnStatusServiceTemporarilyUnavailableWhenPurchaseServiceFailed() throws Exception {
		when(purchaseService.exist(fakePO)).thenReturn(false);
        when(purchaseService.create(purchase)).thenThrow(new ServiceException("Problem with DB connection"));
        
        mockMvc.perform(post("/purchases")
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(Utils.asJsonString(purchase)))	
				.andExpect(status().is(503));
	}
}