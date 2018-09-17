package com.usel.app.services;

import java.util.Optional;
import org.mockito.Mockito;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.usel.app.model.Customer;
import com.usel.app.repository.CustomerRepository;
import com.usel.app.service.CustomerService;
import com.usel.app.service.exception.ServiceException;
import com.usel.app.service.impl.CustomerServiceImpl;

@RunWith(SpringRunner.class)
public class CustomerServiceImplTest {

	@TestConfiguration
	static class CustomerServiceImplTestContextConfiguration {

		@Bean
		CustomerService customerService() {
			return new CustomerServiceImpl();
		}
	}

	@Autowired
	CustomerService customerService;

	@MockBean
	CustomerRepository mockCustomerRepository;

	int id;
	Optional<Customer> customer;

	@Before
	public void setUp() {
		Customer customer = new Customer();
		Mockito.when(mockCustomerRepository.save(customer)).thenReturn(customer);
		Mockito.when(mockCustomerRepository.findById(id)).thenReturn(Optional.of(customer));
	}

	@Test
	public void findAllShouldInvokeOnceUserRepositoryfindAllMethod() throws ServiceException {
		customerService.findAll();
		Mockito.verify(mockCustomerRepository, Mockito.times(1)).findAll();
	}

	@Test
	public void createShouldInvokeOnceUserRepositorySaveMethod() throws ServiceException {
		customerService.create(customer);
		Mockito.verify(mockCustomerRepository, Mockito.times(1)).save(Optional.of(customer));
	}

	@Test
	public void getUserByIdShouldNotReturnNull() throws ServiceException {
		Assert.assertNotNull(customerService.findBy(id));
	}

	@Test
	public void getUserByEmailShouldInvokeOnceUserRepositoryfindByEmailMethod() throws ServiceException {
		customerService.findBy(id);
		Mockito.verify(mockCustomerRepository, Mockito.times(1)).findById(id);
	}

	@Test
	public void createByShouldInvokeOnceUserRepositorySaveMethod() throws ServiceException {
		customerService.createBy(customer);
		Mockito.verify(mockCustomerRepository, Mockito.times(1)).save(Optional.of(customer));
	}

	@Test
	public void deleteByShouldReturnNull() throws ServiceException {
		customerService.deleteBy(id);
		Assert.assertNotNull(customerService.findBy(id));
	}
}
