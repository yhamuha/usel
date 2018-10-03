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
	
    MockMvc mockMvc;
	
	@MockBean
	UserService userService;
	
	User user;
	List<User> users;
	String userId;
	String fakeEmail = "no_test@gmail.com";
	String email = "test@gmail.com";
	
	@Before
    public void setUp() {
		mockMvc = standaloneSetup(userController).build();
        this.user = new User();
        user.setName("FirstName");
        user.setLastName("LastName");
        user.setEmail("test@gmail.com");
        user.setPassword("qwerty");
        user.setShortName("FL");
        user.setPoId(2040);
        
        users = new ArrayList<User>();

        System.out.println("User in @Before" + user.toString());
    }
	
	// @Test
	public void testGetAllSuccess() throws Exception {
		this.users.add(this.user);
		this.users.add(this.user);
		when(userService.findAll()).thenReturn(users);

		mockMvc.perform(get("/users"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(jsonPath("$", hasSize(2)));
		
		verify(userService, times(1)).findAll();
		verifyNoMoreInteractions(userService);
	}
	
	// @Test
	public void getAllShouldReturnStatusNoContentWhenUserListEmpty() throws Exception {
		when(userService.findAll()).thenReturn(users);
		
		mockMvc.perform(get("/users"))
			.andExpect(status().isNoContent());
	}
	
	// @Test
	public void getAllShouldReturnStatusServiceTemporarilyUnavailableWhenUserServiceFailed() throws Exception {
		when(userService.findAll()).thenThrow(new ServiceException("Problem with DB connection"));
		
		mockMvc.perform(get("/users"))
		   .andExpect(status().is(503));
	}
	
	@Test
	public void testCreateUserSuccess() throws Exception {
		
		System.out.println("CHECK POINT 1");
		System.out.println("User in POINT 1" + user.toString());
		
		when(userService.exist(fakeEmail)).thenReturn(false); 
        when(userService.create(user)).thenReturn(user); 
        
        System.out.println("How to send to method()" + Utils.asJsonString(this.user));
        
        mockMvc.perform(post("/users")                  
        		.contentType(MediaType.APPLICATION_JSON) 
        		.content(Utils.asJsonString(this.user)))
        		.andExpect(status().isCreated())  
				.andExpect(header().string("location", containsString("http://localhost:8080/users/" + user.getId())));
	
		verify(userService, times(1)).exist(user.getEmail()); 
		verify(userService, times(1)).create(user); 
	}
	
	// @Test
	public void createShouldReturnStatusConflictWhenUserExists() throws Exception {
		when(userService.exist(user.getEmail())).thenReturn(true);
        
		mockMvc.perform(post("/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Utils.asJsonString(user)))	
				.andExpect(status().isConflict());
	}
	
	// @Test
	public void createShouldReturnStatusServiceTemporarilyUnavailableWhenUserServiceFailed() throws Exception {
		when(userService.exist(fakeEmail)).thenReturn(false);
        when(userService.create(user)).thenThrow(new ServiceException("Problem with DB connection"));
        
        mockMvc.perform(post("/users")
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(Utils.asJsonString(user.getEmail())))	
				.andExpect(status().is(503));
	}
}