package com.usel.app.tests;
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
import org.springframework.util.Assert;

import com.usel.app.model.User;
import com.usel.app.repository.UserRepository;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@TestPropertySource(locations="classpath:application.yml")
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class UserRepositoryTest {
	
	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	
	// Need to use methods from JPARepository
	
	
	public void whenFindAllThenReturnNotEmptyList() {
		User user = new User();
		user.setName("Test Name");
		user.setLastName("Test LastName");
		user.setEmail("Test email");
		user.setPassword("Test Password");

		entityManager.persist(user);

		assertFalse(userRepository.findAll().isEmpty());
		
	}
	@Test
    public void findByEmailWhenPersonExistsShouldReturnIt() {
        List<Person> persons = personRepository.findByNameLike("J%");
        assertEquals(2, persons.size());
    }
}
