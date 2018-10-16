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
import com.usel.app.model.Customer;
import com.usel.app.service.CustomerService;
import com.usel.app.service.exception.ServiceException;

@RunWith(SpringRunner.class)
public class CustomerControllerTest {
	
	@InjectMocks
	CustomerController customerController;

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
    MockMvc mockMvc;
	
	@MockBean
	CustomerService customerService;
	
	Customer customer;
	List<Customer> customers;
	int fakeId = -1;
	
	@Before
    public void setUp() {
		mockMvc = standaloneSetup(customerController).build();
        this.customer = new Customer();
        customer.setName("FirstName");
        customer.setOwnPo(4020);
        customers = new ArrayList<Customer>();
    }
	
	@Test
	public void testGetAllSuccess() throws Exception {
		this.customers.add(this.customer);
		this.customers.add(this.customer);
		when(customerService.findAll()).thenReturn(customers);

		mockMvc.perform(get("/customers"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(jsonPath("$", hasSize(2)));
		
		verify(customerService, times(1)).findAll();
		verifyNoMoreInteractions(customerService);
	}
	
	@Test
	public void getAllShouldReturnStatusNoContentWhenCustomerListEmpty() throws Exception {
		when(customerService.findAll()).thenReturn(customers);
		
		mockMvc.perform(get("/customers"))
			.andExpect(status().isNoContent());
	}
	
	@Test
	public void getAllShouldReturnStatusServiceTemporarilyUnavailableWhenCustomerServiceFailed() throws Exception {
		when(customerService.findAll()).thenThrow(new ServiceException("Problem with DB connection"));
		
		mockMvc.perform(get("/customers"))
		   .andExpect(status().is(503));
	}
	
	@Test
	public void testCreateCustomerSuccess() throws Exception {
		
		when(customerService.exist(fakeId)).thenReturn(false); 
        when(customerService.create(customer)).thenReturn(customer); 
        
        mockMvc.perform(post("/customers")                  
        		.contentType(MediaType.APPLICATION_JSON) 
        		.content(Utils.asJsonString(customer)))
        		.andExpect(status().isCreated())  
				.andExpect(header().string("location", containsString("http://localhost/customers/" + customer.getId())));
	
		verify(customerService, times(1)).exist(customer.getId()); 
		verify(customerService, times(1)).create(customer); 
	}
	
	@Test
	public void createShouldReturnStatusConflictWhenCustomerExists() throws Exception {
		when(customerService.exist(customer.getId())).thenReturn(true);
		mockMvc.perform(post("/customers")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Utils.asJsonString(customer)))	
				.andExpect(status().isConflict());
	}
	
	@Test
	public void createShouldReturnStatusServiceTemporarilyUnavailableWhenCustomerServiceFailed() throws Exception {
		when(customerService.exist(fakeId)).thenReturn(false);
        when(customerService.create(customer)).thenThrow(new ServiceException("Problem with DB connection"));
        
        mockMvc.perform(post("/customers")
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(Utils.asJsonString(customer)))	
				.andExpect(status().is(503));
	}
}
