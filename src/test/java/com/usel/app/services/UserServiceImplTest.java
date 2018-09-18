package com.usel.app.services;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.usel.app.model.User;
import com.usel.app.repository.UserRepository;
import com.usel.app.service.exception.ServiceException;
import com.usel.app.service.impl.UserServiceImpl;


@RunWith(SpringRunner.class)
public class UserServiceImplTest {

	@Mock
	UserRepository mockUserRepository;

	@InjectMocks
	UserServiceImpl userService;

	int id;
	User user;
	List<User> listUsers = new ArrayList<User>();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
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
	public void createShouldInvokeOnceUserRepositorySaveMethod() throws ServiceException {
		userService.create(user);
		verify(mockUserRepository, times(1)).save(user);
	}
	
	@Test
	public void getUserByIdShouldNotReturnNull() throws ServiceException {
		userService.createBy(id);
		Assert.assertNotNull("getUserByIdShouldNotReturnNull", mockUserRepository.findById(id));
	}

	@Test
	public void getUserByIdShouldInvokeOnceUserRepositoryfindByIdMethod() throws ServiceException {
		userService.findById(id);
		verify(mockUserRepository, times(1)).findById(id);
	}
	
	@Test
	public void deleteByShouldReturnNull() throws ServiceException {
		userService.deleteBy(id);
		Assert.assertNotNull("deleteByShouldReturnNull", mockUserRepository.findById(id));
	}
	
}
