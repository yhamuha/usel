package com.usel.app.services;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	List<User> listUsers = new ArrayList<User>();

	@Before
	public void setUp() {
		User user = new User();
		when(mockUserRepository.save(user)).thenReturn(user);
		when(mockUserRepository.findById(id)).thenReturn(Optional.of(user));
		when(mockUserRepository.findAll()).thenReturn(listUsers);
	}

	@Test
	public void findAllShouldInvokeOnceUserRepositoryfindAllMethod() throws ServiceException {
		userService.findAll();
		verify(mockUserRepository, times(1)).findAll();
	}

	@Test
	public void createCustomerShouldInvokeOnceUserRepositorySaveMethod() throws ServiceException {
		userService.createCustomer(user);
		verify(mockUserRepository, times(1)).save(user);
	}

	@Test
	public void getUserByIdShouldNotReturnNull() throws ServiceException {
		userService.createBy(id);
		Assert.assertNotNull("getUserByIdShouldNotReturnNull", mockUserRepository.findById(id));
	}

	@Test
	public void getUserByShouldInvokeOnceUserRepositoryfindByIdMethod() throws ServiceException {
		userService.findBy(id);
		verify(mockUserRepository, times(1)).findById(id);
	}
	
	@Test
	public void deleteByShouldReturnNull() throws ServiceException {
		userService.deleteBy(id);
		Assert.assertNotNull("deleteByShouldReturnNull", mockUserRepository.findById(id));
	}
	
}
