package com.usel.app.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.usel.app.model.User;
import com.usel.app.service.UserService;
import com.usel.app.service.exception.ServiceException;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public List<User> findAll() throws ServiceException {
		return null;
	}

	@Override
	public void createCustomer(Optional<User> user) throws ServiceException {
	}

	@Override
	public User findBy(int userId) throws ServiceException {
		return null;
	}

	@Override
	public void createBy(int userId) throws ServiceException {
		
	}

	@Override
	public void deleteBy(int userId) throws ServiceException {
		
	}

	@Override
	public boolean isEnabled(User userId) throws ServiceException {
		return false;
	}

}
