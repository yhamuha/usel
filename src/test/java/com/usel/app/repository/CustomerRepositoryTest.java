package com.usel.app.repository;

import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import com.usel.app.model.Customer;
import com.usel.app.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@TestPropertySource(locations="classpath:application.yml")
@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class CustomerRepositoryTest {
	@Autowired
    private TestEntityManager entityManager;
	
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















 
    