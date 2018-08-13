package com.usel.app.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.usel.app.model.Customer;
import com.usel.app.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private CustomerRepository customerRepository;
    
    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        Customer alex = new Customer(1, "alex");
        entityManager.persist(alex);
        entityManager.flush();
     
        // when
        Customer found = customerRepository.getCustomerById(id));
     
        // then
        assertThat(found.getName())
          .isEqualTo(alex.getName());
    }
}















 
    