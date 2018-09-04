package com.usel.app.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.usel.app.model.User;
import com.usel.app.repository.UserRepository;
import com.usel.app.service.UserService;
import com.usel.app.service.exception.ServiceException;
import com.usel.app.service.impl.UserServiceImpl;

@RunWith(SpringRunner.class)
public class UserServiceImplTest {

	@TestConfiguration
	static class UserServiceImplTestContextConfiguration {

		@Bean
		UserService userService() {
			return new UserServiceImpl();
		}
	}

	@Autowired
	UserService userService;

	@MockBean
	UserRepository userRepository;
	
	int id;
	User user;

	@Before
	public void setUp() {
		user = new User();
		when(userRepository.save(user)).thenReturn(user);
		when(userRepository.findById(id)).thenReturn(user);
	}

	@Test
	public void findAllShouldInvokeOnceUserRepositoryfindAllMethod() throws ServiceException {
		userService.findAll();
		verify(userRepository, times(1)).findAll();
	}

	@Test
	public void createCustomerShouldNotReturnNull() throws ServiceException {
		userService.createCustomer(user);
		assertNotNull(userService.createCustomer(user));
	}
	
	@Test
	public void createShouldInvokeOnceUserRepositorySaveMethod() throws ServiceException {
		userService.createCustomer(user);
		verify(userRepository, times(1)).save(user);
	}

	@Test
	public void getUserByIdShouldNotReturnNull() throws ServiceException {
		assertNotNull(userService.findBy(id));
	}

	@Test
	public void getUserByEmailShouldInvokeOnceUserRepositoryfindByEmailMethod() throws ServiceException {
		userService.findBy(id);
		verify(userRepository, times(1)).findById(id);
	}
	
	@Test
	public void createByShouldInvokeOnceUserRepositorySaveMethod() throws ServiceException {
		userService.createBy(id);
		verify(userRepository, times(1)).save(user);
	}
	
	@Test
	public void deleteByShouldReturnNull() throws ServiceException {
		userService.deleteBy(id);
		assertNull(userService.findBy(id));
	}
	
}
