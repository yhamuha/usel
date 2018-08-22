package com.usel.app.repository;

import static org.junit.Assert.assertFalse;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.usel.app.model.Customer;
import com.usel.app.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@TestPropertySource(locations="classpath:application.yml")
@DataJpaTest
@ContextConfiguration
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class CustomerRepositoryTest {
	@Autowired
    private EntityManager entityManager;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Test
	public void whenFindAllThenReturnNotEmptyList() {
		Customer customer = new Customer();
		
		customer.setName("Test Customer");
		customer.setOwnPo(120033);
		
		entityManager.persist(customer);

		assertFalse(customerRepository.findAll().isEmpty());
	}
}















 
    