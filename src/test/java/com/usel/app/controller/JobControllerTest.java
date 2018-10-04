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
import com.usel.app.model.Job;
import com.usel.app.service.JobService;
import com.usel.app.service.exception.ServiceException;

@RunWith(SpringRunner.class)
public class JobControllerTest {
	
	@InjectMocks
	JobController jobController;

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
    MockMvc mockMvc;
	
	@MockBean
	JobService jobService;
	
	Job job;
	List<Job> jobs;
	int jobId;
	int fakeId = -1;
	
	@Before
    public void setUp() {
		mockMvc = standaloneSetup(jobController).build();
        this.job = new Job();
        job.setDescription("Generator test");
        job.setDueDate("10/5/18");
        job.setmSSale("");
        job.setCustomerId(2);
        job.setPoId(2);
        jobs = new ArrayList<Job>();
    }
	
	@Test
	public void testGetAllSuccess() throws Exception {
		this.jobs.add(this.job);
		this.jobs.add(this.job);
		when(jobService.findAll()).thenReturn(jobs);

		mockMvc.perform(get("/jobs"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(jsonPath("$", hasSize(2)));
		
		verify(jobService, times(1)).findAll();
		verifyNoMoreInteractions(jobService);
	}
	
	@Test
	public void getAllShouldReturnStatusNoContentWhenJobListEmpty() throws Exception {
		when(jobService.findAll()).thenReturn(jobs);
		
		mockMvc.perform(get("/jobs"))
			.andExpect(status().isNoContent());
	}
	
	@Test
	public void getAllShouldReturnStatusServiceTemporarilyUnavailableWhenJobServiceFailed() throws Exception {
		when(jobService.findAll()).thenThrow(new ServiceException("Problem with DB connection"));
		
		mockMvc.perform(get("/jobs"))
		   .andExpect(status().is(503));
	}
	
	@Test
	public void testCreateJobSuccess() throws Exception {
		
		when(jobService.exist(fakeId)).thenReturn(false); 
        when(jobService.create(job)).thenReturn(job); 
        
        mockMvc.perform(post("/jobs")                  
        		.contentType(MediaType.APPLICATION_JSON) 
        		.content(Utils.asJsonString(job)))
        		.andExpect(status().isCreated())  
				.andExpect(header().string("location", containsString("http://localhost/jobs/" + job.getId())));
	
		verify(jobService, times(1)).exist(job.getId()); 
		verify(jobService, times(1)).create(job); 
	}
	
	@Test
	public void createShouldReturnStatusConflictWhenJobExists() throws Exception {
		when(jobService.exist(job.getId())).thenReturn(true);
		mockMvc.perform(post("/jobs")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Utils.asJsonString(job)))	
				.andExpect(status().isConflict());
	}
	
	@Test
	public void createShouldReturnStatusServiceTemporarilyUnavailableWhenJobServiceFailed() throws Exception {
		when(jobService.exist(fakeId)).thenReturn(false);
        when(jobService.create(job)).thenThrow(new ServiceException("Problem with DB connection"));
        
        mockMvc.perform(post("/jobs")
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(Utils.asJsonString(job)))	
				.andExpect(status().is(503));
	}
}