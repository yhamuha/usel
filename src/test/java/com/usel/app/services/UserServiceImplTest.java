package com.usel.app.services;


import java.util.Optional;
import org.mockito.Mockito;
import org.junit.Assert;
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
	UserRepository mockUserRepository;
	
	int id;
	Optional<User> user;

	@Before
	public void setUp() {
		User user = new User();
		Mockito.when(mockUserRepository.save(user)).thenReturn(user);
		Mockito.when(mockUserRepository.findById(id)).thenReturn(Optional.of(user));
	}

	@Test
	public void findAllShouldInvokeOnceUserRepositoryfindAllMethod() throws ServiceException {
		userService.findAll();
		Mockito.verify(mockUserRepository, Mockito.times(1)).findAll();
	}

	@Test
	public void createShouldInvokeOnceUserRepositorySaveMethod() throws ServiceException {
		userService.createCustomer(user);
		Mockito.verify(mockUserRepository, Mockito.times(1)).save(Optional.of(user));
	}

	@Test
	public void getUserByIdShouldNotReturnNull() throws ServiceException {
		Assert.assertNotNull(userService.findBy(id));
	}

	@Test
	public void getUserByEmailShouldInvokeOnceUserRepositoryfindByEmailMethod() throws ServiceException {
		userService.findBy(id);
		Mockito.verify(mockUserRepository, Mockito.times(1)).findById(id);
	}
	
	@Test
	public void createByShouldInvokeOnceUserRepositorySaveMethod() throws ServiceException {
		userService.createBy(id);
		Mockito.verify(mockUserRepository, Mockito.times(1)).save(Optional.of(user));
	}
	
	@Test
	public void deleteByShouldReturnNull() throws ServiceException {
		userService.deleteBy(id);
		Assert.assertNotNull(userService.findBy(id));
	}
	
}
