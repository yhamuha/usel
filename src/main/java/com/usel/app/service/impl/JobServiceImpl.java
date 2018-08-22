package com.usel.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.usel.app.model.Job;
import com.usel.app.service.JobService;
import com.usel.app.service.exception.ServiceException;

@Service
public class JobServiceImpl implements JobService{

	@Override
	public List<Job> findAll() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createJob(Job job) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Job findBy(int jobId) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createBy(int jobId) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBy(int jobId) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

}
