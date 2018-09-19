package com.usel.app.services;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
		when(mockUserRepository.saveAndFlush(user)).thenReturn(user);
	}
	
	@Test
	public void findAllShouldInvokeOnceUserRepositoryFindAllMethod() throws ServiceException {
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
		userService.create(user);
		assertNotNull("findUserByIdShouldNotReturnNull", mockUserRepository.findById(id));
	}

	@Test
	public void getUserByIdShouldInvokeOnceUserRepositoryFindByIdMethod() throws ServiceException {
		userService.findById(id);
		verify(mockUserRepository, times(1)).findById(id);
	}
	
	@Test
	public void  updateShouldInvokeOnceUserRepositorySaveAndFlushMethod() throws ServiceException {
		userService.update(user);
		verify(mockUserRepository, times(1)).saveAndFlush(user);
	}
	
	@Test
	public void deleteByIdShouldReturnNull() throws ServiceException {
		userService.deleteById(id);
		assertNotNull("deleteByIdShouldReturnNull", mockUserRepository.findById(id));
	}
	
}
