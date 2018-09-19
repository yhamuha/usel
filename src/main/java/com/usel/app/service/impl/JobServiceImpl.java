package com.usel.app.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.usel.app.model.Job;
import com.usel.app.repository.JobRepository;
import com.usel.app.service.JobService;
import com.usel.app.service.exception.ServiceException;

@Service
public class JobServiceImpl implements JobService{

	JobRepository jobRepository;
	
	public JobServiceImpl(JobRepository jobRepository) { 
		this.jobRepository = jobRepository;
	}
	
	@Override
	public List<Job> findAll() throws ServiceException {
		return jobRepository.findAll();
	}

	@Override
	public Job create(Job job) throws ServiceException {
		return jobRepository.save(job);
	}
	
	@Override
	public Optional<Job> findById(int jobId) throws ServiceException {
		return jobRepository.findById(jobId);
	}

	@Override
	public Job update(Job job) throws ServiceException {
		return jobRepository.saveAndFlush(job);
	}

	@Override
	public void deleteById(int jobId) throws ServiceException {
	}

}
