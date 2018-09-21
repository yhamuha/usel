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
	List<User> users;
	
	@Before
    public void setUp() {
        mvc = standaloneSetup(userController).build();
        user = new User();
        user.setId(1);
        user.setName("First Name");
        user.setLastName("Last Name");
        user.setShortName("FL");
        user.setPassword("qwerty");
        user.setPoId(2040);
        users = new ArrayList<>();
    }
	
	@Test
	public void testGetAllSuccess() throws Exception {
		this.users.add(this.user);
		this.users.add(this.user);
		when(userService.findAll()).thenReturn(users);
		
		mvc.perform(get("/users"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(jsonPath("$", hasSize(2)));
		
		verify(userService, times(1)).findAll();
		verifyNoMoreInteractions(userService);
	}
	
	@Test
	public void getAllShouldReturnStatusNoContentWhenUserListEmpty() throws Exception {
		when(userService.findAll()).thenReturn(users);
		
		mvc.perform(get("/users"))
			.andExpect(status().isNoContent());
	}
	
	@Test
	public void getAllShouldReturnStatusServiceTemporarilyUnavailableWhenUserServiceFailed() throws Exception {
		when(userService.findAll()).thenThrow(new ServiceException("Problem with DB connection"));
		
		mvc.perform(get("/surveys"))
		   .andExpect(status().is(503));
	}
	
	
	@Test
	public void testCreateUserSuccess() throws Exception {
		when(userService.exist(user)).thenReturn(false);
        when(userService.create(user)).thenReturn(user);
        
		mvc.perform(post("/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Utils.asJsonString(user)))	
				.andExpect(status().isCreated())
				.andExpect(header().string("location", containsString("http://localhost/users/" + userId)));
	
		//verify(userService, times(1)).exists(user);
		verify(userService, times(1)).create(user);
	}
	
	@Test
	public void createShouldReturnStatusConflictWhenSurveyExists() throws Exception {
		when(userService.exists(user)).thenReturn(true);
        
        mvc.perform(post("/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Utils.asJsonString(user)))	
				.andExpect(status().isConflict());
	}
	
	@Test
	public void createShouldReturnStatusServiceTemporarilyUnavailableWhenUserServiceFailed() throws Exception {
		when(userService.exists(user)).thenReturn(false);
        when(userService.create(user)).thenThrow(new ServiceException("Problem with DB connection"));
        
        mvc.perform(post("/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Utils.asJsonString(user)))	
				.andExpect(status().is(503));
	}
}