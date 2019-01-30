package com.usel.app.services;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
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
		when(mockCustomerRepository.findAll()).thenReturn(listCustomers);
		when(mockCustomerRepository.saveAndFlush(customer)).thenReturn(customer);
	}

	@Test
	public void findAll_ShouldInvokeOnceUserRepositoryFindAllMethod() throws ServiceException {
		customerService.findAll();
		verify(mockCustomerRepository, times(1)).findAll();
	}
	
	@Test
	public void create_ShouldInvokeOnceCustomerRepositorySaveMethod() throws ServiceException {
		customerService.create(customer);
		verify(mockCustomerRepository, times(1)).save(customer);
	}
	
	@Test
	public void  update_ShouldInvokeOnceCustomerRepositorySaveAndFlushMethod() throws ServiceException {
		customerService.update(customer);
		verify(mockCustomerRepository, times(1)).saveAndFlush(customer);
	}

	@Test
	public void findById_ShouldNotReturnNull() throws ServiceException {
		assertNotNull(customerService.findById(id));
	}
	
	@Test
	public void deleteById_InvokeOnceDeleteByIdRepositoryMethod() throws ServiceException {
		customerService.deleteById(id);
		verify(mockCustomerRepository, times(1)).deleteById(id);
	}
}
