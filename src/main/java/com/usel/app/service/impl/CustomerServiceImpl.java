package com.usel.app.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.usel.app.model.Customer;
import com.usel.app.service.CustomerService;
import com.usel.app.service.exception.ServiceException;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	CustomerService customerService;

	@Override
	public List<Customer> findAll() throws ServiceException {
		return null;
	}

	@Override
	public void create(Optional<Customer> customer) throws ServiceException {
	}

	@Override
	public Customer findBy(int customerId) throws ServiceException {
		return null;
	}

	@Override
	public void createBy(Optional<Customer> customer) throws ServiceException {
	}

	@Override
	public void deleteBy(int customerId) throws ServiceException {
	}


}
