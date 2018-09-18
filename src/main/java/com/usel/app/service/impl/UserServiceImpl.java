package com.usel.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.usel.app.model.User;
import com.usel.app.repository.UserRepository;
import com.usel.app.service.UserService;
import com.usel.app.service.exception.ServiceException;

@Service
public class UserServiceImpl implements UserService{
	
	UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) { 
		this.userRepository = userRepository;
	}
	
	@Override
	public List<User> findAll() throws ServiceException {
		return userRepository.findAll();
	}

	@Override
	public User create(User user) throws ServiceException {
		return userRepository.save(user);
	}
	
	/*@Override
	public Optional<User> findById(int userId) throws ServiceException {
		return userRepository.findById(userId);
	}*/

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
