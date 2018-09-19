package com.usel.app.services;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import com.usel.app.model.Job;
import com.usel.app.repository.JobRepository;
import com.usel.app.service.exception.ServiceException;
import com.usel.app.service.impl.JobServiceImpl;

@RunWith(SpringRunner.class)
public class JobServiceImplTest {

	@Mock
	JobRepository mockJobRepository;

	@InjectMocks
	JobServiceImpl jobService;

	int id;
	Job job;
	List<Job> listJobs = new ArrayList<Job>();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		Job job = new Job();
		when(mockJobRepository.save(job)).thenReturn(job);
		when(mockJobRepository.findById(id)).thenReturn(Optional.of(job));
		when(mockJobRepository.findAll()).thenReturn(listJobs);
	}

	@Test
	public void findAllShouldInvokeOnceUserRepositoryfindAllMethod() throws ServiceException {
		jobService.findAll();
		verify(mockJobRepository, times(1)).findAll();
	}

	@Test
	public void createShouldInvokeOnceUserRepositorySaveMethod() throws ServiceException {
		jobService.create(job);
		verify(mockJobRepository, times(1)).save(job);
	}

	@Test
	public void getJobByIdShouldNotReturnNull() throws ServiceException {
		jobService.createById(id);
		assertNotNull("findJobByIdShouldNotReturnNull", mockJobRepository.findById(id));
	}
	
	@Test
	public void getJobByIdShouldInvokeOnceJobRepositoryFindByIdMethod() throws ServiceException {
		jobService.findById(id);
		verify(mockJobRepository, times(1)).findById(id);
	}

	@Test
	public void deleteByShouldReturnNull() throws ServiceException {
		jobService.deleteById(id);
		assertNotNull("deleteByIdShouldReturnNull", mockJobRepository.findById(id));
	}
}
