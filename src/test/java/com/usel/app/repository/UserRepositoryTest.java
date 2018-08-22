package com.usel.app.repository;

import static org.junit.Assert.assertFalse;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.usel.app.model.User;
import com.usel.app.repository.UserRepository;

@RunWith(SpringRunner.class)

@TestPropertySource(locations="classpath:application.yml")
@DataJpaTest
@ContextConfiguration
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class UserRepositoryTest {
	
	@Autowired
    private EntityManager entityManager;
	
	@Autowired
	UserRepository userRepository;
	
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