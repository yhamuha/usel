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
import java.util.UUID;
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
import com.usel.app.model.User;
import com.usel.app.service.UserService;
import com.usel.app.service.exception.ServiceException;

@RunWith(SpringRunner.class)
public class UserControllerTest {
	
	@InjectMocks
	UserController userController;

	@Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
	
    MockMvc mvc;
	
	@MockBean
	UserService userService;
	
	User user;
	String userId;
	List<User> surveys;
	
	@Before
    public void setUp() {
        mvc = standaloneSetup(userController).build();
        userId = "d290f1ee-6c54-4b01-90e6-d701748f0851";
        user = new User();
        user.setId(UUID.fromString(userId));
        user.setName("TestUser");
        surveys = new ArrayList<>();
    }
	
	@Test
	public void testGetAllSuccess() throws Exception {
		this.surveys.add(this.user);
		this.surveys.add(this.user);
		when(userService.findAll()).thenReturn(surveys);
		
		mvc.perform(get("/surveys"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(jsonPath("$", hasSize(2)));
		
		verify(userService, times(1)).findAll();
		verifyNoMoreInteractions(userService);
	}
	
	@Test
	public void getAllShouldReturnStatusNoContentWhenSurveysListEmpty() throws Exception {
		when(userService.findAll()).thenReturn(surveys);
		
		mvc.perform(get("/surveys"))
			.andExpect(status().isNoContent());
	}
	
	@Test
	public void getAllShouldReturnStatusServiceTemporarilyUnavailableWhenSurveyServiceFailed() throws Exception {
		when(userService.findAll()).thenThrow(new ServiceException("Problem with DB connection"));
		
		mvc.perform(get("/surveys"))
		   .andExpect(status().is(503));
	}
	
	
	@Test
	public void testCreateSurveySuccess() throws Exception {
		when(userService.exists(user)).thenReturn(false);
        when(userService.create(user)).thenReturn(user);
        
		mvc.perform(post("/surveys")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Utils.asJsonString(user)))	
				.andExpect(status().isCreated())
				.andExpect(header().string("location", containsString("http://localhost/surveys/" + userId)));
	
		verify(userService, times(1)).exists(user);
		verify(userService, times(1)).create(user);
	}
	
	@Test
	public void createShouldReturnStatusConflictWhenSurveyExists() throws Exception {
		when(userService.exists(user)).thenReturn(true);
        
        mvc.perform(post("/surveys")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Utils.asJsonString(user)))	
				.andExpect(status().isConflict());
	}
	
	@Test
	public void createShouldReturnStatusServiceTemporarilyUnavailableWhenSurveyServiceFailed() throws Exception {
		when(userService.exists(user)).thenReturn(false);
        when(userService.create(user)).thenThrow(new ServiceException("Problem with DB connection"));
        
        mvc.perform(post("/surveys")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Utils.asJsonString(user)))	
				.andExpect(status().is(503));
	}
}