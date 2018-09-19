package com.usel.app.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.usel.app.model.Customer;
import com.usel.app.repository.CustomerRepository;
import com.usel.app.service.CustomerService;
import com.usel.app.service.exception.ServiceException;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	CustomerRepository customerRepository;
	
	public CustomerServiceImpl(CustomerRepository customerRepository) { 
		this.customerRepository = customerRepository;
	}
	
	@Override
	public List<Customer> findAll() throws ServiceException {
		return customerRepository.findAll();
	}

	@Override
	public Customer create(Customer customer) throws ServiceException {
		return customerRepository.save(customer);
	}

	@Override
	public Optional<Customer> findById(int customerId) throws ServiceException {
		return customerRepository.findById(customerId);
	}

	@Override
	public void createById(int customerId) throws ServiceException {
		
	}

	@Override
	public void deleteById(int customerId) throws ServiceException {
	}


}
