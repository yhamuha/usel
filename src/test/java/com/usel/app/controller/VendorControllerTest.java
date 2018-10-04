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
import com.usel.app.model.Vendor;
import com.usel.app.service.VendorService;
import com.usel.app.service.exception.ServiceException;

@RunWith(SpringRunner.class)
public class VendorControllerTest {
	
	@InjectMocks
	VendorController vendorController;

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
    MockMvc mockMvc;
	
	@MockBean
	VendorService vendorService;
	
	Vendor vendor;
	List<Vendor> vendors;
	int fakeId = -1;
	
	@Before
    public void setUp() {
		mockMvc = standaloneSetup(vendorController).build();
        this.vendor = new Vendor();
        vendor.setName("Platt");
        vendors = new ArrayList<Vendor>();
    }
	
	@Test
	public void testGetAllSuccess() throws Exception {
		this.vendors.add(this.vendor);
		this.vendors.add(this.vendor);
		when(vendorService.findAll()).thenReturn(vendors);

		mockMvc.perform(get("/vendors"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(jsonPath("$", hasSize(2)));
		
		verify(vendorService, times(1)).findAll();
		verifyNoMoreInteractions(vendorService);
	}
	
	@Test
	public void getAllShouldReturnStatusNoContentWhenVendorListEmpty() throws Exception {
		when(vendorService.findAll()).thenReturn(vendors);
		
		mockMvc.perform(get("/vendors"))
			.andExpect(status().isNoContent());
	}
	
	@Test
	public void getAllShouldReturnStatusServiceTemporarilyUnavailableWhenVendorServiceFailed() throws Exception {
		when(vendorService.findAll()).thenThrow(new ServiceException("Problem with DB connection"));
		
		mockMvc.perform(get("/vendors"))
		   .andExpect(status().is(503));
	}
	
	@Test
	public void testCreateVendorSuccess() throws Exception {
		
		when(vendorService.exist(fakeId)).thenReturn(false); 
        when(vendorService.create(vendor)).thenReturn(vendor); 
        
        mockMvc.perform(post("/vendors")                  
        		.contentType(MediaType.APPLICATION_JSON) 
        		.content(Utils.asJsonString(vendor)))
        		.andExpect(status().isCreated())  
				.andExpect(header().string("location", containsString("http://localhost/vendors/" + vendor.getId())));
	
		verify(vendorService, times(1)).exist(vendor.getId()); 
		verify(vendorService, times(1)).create(vendor); 
	}
	
	@Test
	public void createShouldReturnStatusConflictWhenVendorExists() throws Exception {
		when(vendorService.exist(vendor.getId())).thenReturn(true);
		mockMvc.perform(post("/vendors")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Utils.asJsonString(vendor)))	
				.andExpect(status().isConflict());
	}
	
	@Test
	public void createShouldReturnStatusServiceTemporarilyUnavailableWhenVendorServiceFailed() throws Exception {
		when(vendorService.exist(fakeId)).thenReturn(false);
        when(vendorService.create(vendor)).thenThrow(new ServiceException("Problem with DB connection"));
        
        mockMvc.perform(post("/vendors")
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(Utils.asJsonString(vendor)))	
				.andExpect(status().is(503));
	}
}