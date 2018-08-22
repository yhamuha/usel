package com.usel.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.usel.app.model.Customer;
import com.usel.app.service.CustomerService;
import com.usel.app.service.exception.ServiceException;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Override
	public List<Customer> findAll() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createCustomer(Customer customer) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer findBy(int customerId) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createBy(int customerId) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBy(int customerId) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

}
