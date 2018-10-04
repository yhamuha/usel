package com.usel.app.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.usel.app.model.Job;
import com.usel.app.service.JobService;
import com.usel.app.service.exception.ServiceException;


@RestController
@RequestMapping("/jobs")
public class JobController {
	
	private final Logger LOG = LoggerFactory.getLogger(JobController.class);
	
	@Autowired
	JobService jobService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Job>> getAll() {
		LOG.info("getting all jobs");
		
		List<Job> jobs = null;
		try {
			jobs = jobService.findAll();
			if (jobs == null || jobs.isEmpty()){
	            LOG.info("no jobs found");
	            return new ResponseEntity<List<Job>>(HttpStatus.NO_CONTENT);
	        }
		} catch (ServiceException e) {
			LOG.error("getting all surveys failed", e);
			return new ResponseEntity<List<Job>>(HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@PostMapping
	public ResponseEntity<Job> create(@RequestBody Job job, UriComponentsBuilder ucBuilder) {
		LOG.info("creating new job: {}", job.getId());
		Job createdJob;
		
		try {
			if (jobService.exist(job.getId())){
			    LOG.info("a job with name " + job.getId() + " already exists");
			    return new ResponseEntity<Job>(HttpStatus.CONFLICT);
			}
			createdJob = jobService.create(job);
		} catch (ServiceException e) {
			LOG.error("a job with name " + job.getId() + " create failed", e);
			return new ResponseEntity<Job>(HttpStatus.SERVICE_UNAVAILABLE);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/jobs/{id}").buildAndExpand(createdJob.getId()).toUri());
        return new ResponseEntity<Job>(headers, HttpStatus.CREATED);
	}
}