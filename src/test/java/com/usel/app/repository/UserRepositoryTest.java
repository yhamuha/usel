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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.usel.app.model.User;
import com.usel.app.repository.UserRepository;

@RunWith(SpringRunner.class)

@ActiveProfiles("test")
@TestPropertySource(locations="classpath:application.yml")
@DataJpaTest
//@ContextConfiguration
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class UserRepositoryTest {
	
	/*
	 * Use entityManager to persist entity
	 */
	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	UserRepository userRepository;
	
	//TODO: need to create tests of CRUD operations for User entity
	/*
	 * for example:
	 */
	@Test
	public void whenFindAllThenReturnNotEmptyList() {
		User user = new User();
		user.setName("TestUser");
		user.setEmail("test@gmail.com");
		user.setPassword("testpass");
		
		entityManager.persist(user);

		assertFalse(userRepository.findAll().isEmpty());
	}
}