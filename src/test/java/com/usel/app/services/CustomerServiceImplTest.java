package com.usel.app.services;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import com.usel.app.model.Customer;
import com.usel.app.repository.CustomerRepository;
import com.usel.app.service.exception.ServiceException;
import com.usel.app.service.impl.CustomerServiceImpl;

@RunWith(SpringRunner.class)
public class CustomerServiceImplTest {

	@Mock
	CustomerRepository mockCustomerRepository;

	@InjectMocks
	CustomerServiceImpl customerService;

	int id;
	Customer customer;
	List<Customer> listCustomers = new ArrayList<Customer>();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		Customer customer = new Customer();
		when(mockCustomerRepository.save(customer)).thenReturn(customer);
		when(mockCustomerRepository.findById(id)).thenReturn(Optional.of(customer));
		when(mockCustomerRepository.findAll()).thenReturn(listCustomers);
		when(mockCustomerRepository.saveAndFlush(customer)).thenReturn(customer);
	}

	@Test
	public void findAllShouldInvokeOnceUserRepositoryFindAllMethod() throws ServiceException {
		customerService.findAll();
		verify(mockCustomerRepository, times(1)).findAll();
	}
	
	@Test
	public void createShouldInvokeOnceCustomerRepositorySaveMethod() throws ServiceException {
		customerService.create(customer);
		verify(mockCustomerRepository, times(1)).save(customer);
	}
	
	@Test
	public void  updateShouldInvokeOnceCustomerRepositorySaveAndFlushMethod() throws ServiceException {
		customerService.update(customer);
		verify(mockCustomerRepository, times(1)).saveAndFlush(customer);
	}

	@Test
	public void findByIdShouldNotReturnNull() throws ServiceException {
		assertNotNull("findByIdShouldReturnNull", customerService.findById(id));
	}
}
