package com.usel.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.usel.app.model.User;
import com.usel.app.service.UserService;
import com.usel.app.service.exception.ServiceException;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public List<User> findAll() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createCustomer(User user) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findBy(int userId) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createBy(int userId) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBy(int userId) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnabled(User userId) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

}
