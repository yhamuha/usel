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
	
	@Override
	public List<Job> findAll() throws ServiceException {
		return null;
	}

	@Override
	public void create(Optional<Job> job) throws ServiceException {
	}

	@Override
	public Job findBy(int jobId) throws ServiceException {
		return null;
	}

	@Override
	public void createBy(Optional <Job> jobId) throws ServiceException {
	}

	@Override
	public void deleteBy(int jobId) throws ServiceException {
	}

}
