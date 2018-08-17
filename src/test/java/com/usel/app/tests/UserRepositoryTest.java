package com.usel.app.tests;
import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.usel.app.model.User;
import com.usel.app.repository.UserRepository;

//@DirtiesContext
//bridge between Spring Boot test features and JUnit
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {PersistenceContext.class})
@ContextConfiguration
//@ActiveProfiles("test")
//@TestPropertySource(locations="classpath:application.yml")

//provides some standard setup regarding DB, Spring Data, Sources etc.. needed for testing
@DataJpaTest

@AutoConfigureTestDatabase(replace=Replace.NONE)
public class UserRepositoryTest {
	
	@Autowired
    private EntityManager entityManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void whenFindByNameThenReturnShortName() {
		
		// given
	    User alex = new User(1, "Alex", "Johnson", "alex.johnson@gmail.com", "XelaAlex_&^@!", "ALJ", true, true, false, 2996);
	    entityManager.persist(alex);
	    entityManager.flush();
	    
	    // when
	    User found = userRepository.findByName(alex.getName());
	 
	    // then
	    assertThat(found.getName())
	      .isEqualTo(alex.getName());
		
	}
}
