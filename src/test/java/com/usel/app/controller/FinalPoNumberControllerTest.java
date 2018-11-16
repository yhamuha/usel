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
public class FinalPoNumberControllerTest {

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
	
}
