package com.usel.app.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
import com.usel.app.model.User;
import com.usel.app.repository.UserRepository;

@RunWith(SpringRunner.class)
@TestPropertySource(locations="classpath:application.yml")
@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class UserRepositoryTest {
	
	String email = "test@gmail.com";
	
	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void whenFindAllThenReturnNotEmptyList() {
		User user = new User();
		user.setName("TestUser");
		user.setEmail(email);
		user.setPassword("testpass");
		
		entityManager.persist(user);

		assertFalse(userRepository.findAll().isEmpty());
	}
	
	@Test
	public void whenExistsByEmailThenReturnTrue() {
		User user = new User();
		user.setEmail(email);
		
		entityManager.persist(user);

		assertTrue(userRepository.existsByEmail(email));
	}
}