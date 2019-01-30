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
import com.usel.app.model.Vessel;
import com.usel.app.service.VesselService;
import com.usel.app.service.exception.ServiceException;

@RunWith(SpringRunner.class)
public class VesselControllerTest {
	
	@InjectMocks
	VesselController vesselController;

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
    MockMvc mockMvc;
	
	@MockBean
	VesselService vesselService;
	
	Vessel vessel;
	List<Vessel> vessels;
	int fakeId = -1;
	
	@Before
    public void setUp() {
		mockMvc = standaloneSetup(vesselController).build();
        this.vessel = new Vessel();
        vessel.setName("Kodiak");
        //vessel.setCustomerId(2);
        vessels = new ArrayList<Vessel>();
    }
	
	@Test
	public void testGetAllSuccess() throws Exception {
		this.vessels.add(this.vessel);
		this.vessels.add(this.vessel);
		when(vesselService.findAll()).thenReturn(vessels);

		mockMvc.perform(get("/vessels"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(jsonPath("$", hasSize(2)));
		
		verify(vesselService, times(1)).findAll();
		verifyNoMoreInteractions(vesselService);
	}
	
	@Test
	public void getAll_ShouldReturnStatusNoContentWhenVesselListEmpty() throws Exception {
		when(vesselService.findAll()).thenReturn(vessels);
		
		mockMvc.perform(get("/vessels"))
			.andExpect(status().isNoContent());
	}
	
	@Test
	public void getAll_ShouldReturnStatusServiceTemporarilyUnavailableWhenVesselServiceFailed() throws Exception {
		when(vesselService.findAll()).thenThrow(new ServiceException("Problem with DB connection"));
		
		mockMvc.perform(get("/vessels"))
		   .andExpect(status().is(503));
	}
	
	@Test
	public void testCreateVesselSuccess() throws Exception {
		
		when(vesselService.exist(fakeId)).thenReturn(false); 
        when(vesselService.create(vessel)).thenReturn(vessel); 
        
        mockMvc.perform(post("/vessels")                  
        		.contentType(MediaType.APPLICATION_JSON) 
        		.content(Utils.asJsonString(vessel)))
        		.andExpect(status().isCreated())  
				.andExpect(header().string("location", containsString("http://localhost/vessels/" + vessel.getId())));
	
		verify(vesselService, times(1)).exist(vessel.getId()); 
		verify(vesselService, times(1)).create(vessel); 
	}
	
	@Test
	public void create_ShouldReturnStatusConflictWhenVesselExists() throws Exception {
		when(vesselService.exist(vessel.getId())).thenReturn(true);
		mockMvc.perform(post("/vessels")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Utils.asJsonString(vessel)))	
				.andExpect(status().isConflict());
	}
	
	@Test
	public void create_ShouldReturnStatusServiceTemporarilyUnavailableWhenVesselServiceFailed() throws Exception {
		when(vesselService.exist(fakeId)).thenReturn(false);
        when(vesselService.create(vessel)).thenThrow(new ServiceException("Problem with DB connection"));
        
        mockMvc.perform(post("/vessels")
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(Utils.asJsonString(vessel)))	
				.andExpect(status().is(503));
	}
}