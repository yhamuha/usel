package com.usel.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.usel.app.model.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {
	
	public List<Job> getJobs();
	public void postJobs();
	public Job getJobById(Job id);
	public void putJobById(Job id);
	public void deleteJobById(Job id);
	
}