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
import com.usel.app.model.Job;
import com.usel.app.repository.JobRepository;

@RunWith(SpringRunner.class)
@TestPropertySource(locations="classpath:application.yml")
@DataJpaTest
@ActiveProfiles("test")
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
		job.setDueDate("10-18-2018");
		job.setmSSale("Test mSSale value");
		job.setStatus(true);
		
		entityManager.persist(job);

		assertFalse(jobRepository.findAll().isEmpty());
	}
}
