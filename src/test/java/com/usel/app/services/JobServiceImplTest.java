package com.usel.app.services;

import java.util.Optional;
import org.mockito.Mockito;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.usel.app.model.Job;
import com.usel.app.repository.JobRepository;
import com.usel.app.service.JobService;
import com.usel.app.service.exception.ServiceException;
import com.usel.app.service.impl.JobServiceImpl;

@RunWith(SpringRunner.class)
public class JobServiceImplTest {

	@TestConfiguration
	static class JobServiceImplTestContextConfiguration {

		@Bean
		JobService JobService() {
			return new JobServiceImpl();
		}
	}

	@Autowired
	JobService JobService;

	@MockBean
	JobRepository mockJobRepository;

	int id;
	Optional<Job> job;

	@Before
	public void setUp() {
		Job job = new Job();
		Mockito.when(mockJobRepository.save(job)).thenReturn(job);
		Mockito.when(mockJobRepository.findById(id)).thenReturn(Optional.of(job));
	}

	@Test
	public void findAllShouldInvokeOnceUserRepositoryfindAllMethod() throws ServiceException {
		JobService.findAll();
		Mockito.verify(mockJobRepository, Mockito.times(1)).findAll();
	}

	@Test
	public void createShouldInvokeOnceUserRepositorySaveMethod() throws ServiceException {
		JobService.create(job);
		Mockito.verify(mockJobRepository, Mockito.times(1)).save(Optional.of(job));
	}

	@Test
	public void getUserByIdShouldNotReturnNull() throws ServiceException {
		Assert.assertNotNull(JobService.findBy(id));
	}

	@Test
	public void getUserByEmailShouldInvokeOnceUserRepositoryfindByEmailMethod() throws ServiceException {
		JobService.findBy(id);
		Mockito.verify(mockJobRepository, Mockito.times(1)).findById(id);
	}

	@Test
	public void createByShouldInvokeOnceUserRepositorySaveMethod() throws ServiceException {
		JobService.createBy(job);
		Mockito.verify(mockJobRepository, Mockito.times(1)).save(Optional.of(job));
	}

	@Test
	public void deleteByShouldReturnNull() throws ServiceException {
		JobService.deleteBy(id);
		Assert.assertNotNull(JobService.findBy(id));
	}
}
