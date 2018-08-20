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

import com.usel.app.model.Job;
import com.usel.app.repository.JobRepository;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@TestPropertySource(locations="classpath:application.yml")
@DataJpaTest
@ContextConfiguration
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class JobRepositoryTest {
	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	JobRepository jobRepository;
	
	@Test
	public void whenFindAllThenReturnNotEmptyList() {
		Job job = new Job();
		job.setDescription("Job description");
		job.setDueDate("05/18/18");
		job.setmSSale("Test mSSale value");
		job.setStatus(true);
		
		entityManager.persist(job);

		assertFalse(jobRepository.findAll().isEmpty());
	}
}
