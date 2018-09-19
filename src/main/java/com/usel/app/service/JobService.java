package com.usel.app.service;

import java.util.List;
import java.util.Optional;
import com.usel.app.model.Job;
import com.usel.app.service.exception.ServiceException;

public interface JobService {
		
		/**
		 * <p>
		 * This method are getting all the jobs (GET)
	     * @param	none
	     * @return	List of jobs 
	     * </p> 
	     * @throws ServiceException
	     * 			If any errors are encountered in the repository layer 
	     * 			while retrieving data.
		 **/
		List<Job> findAll() throws ServiceException;
		
		/**
		* <p>
		* This method saving Jobs (POST)
		* @param 	job
		* @return 	void 
		* </p> 
		* @throws ServiceException
		* 			If any errors are encountered in the repository layer
		*           while saving data.
		**/
		Job create(Job job) throws ServiceException;
		
		/**
		 * <p>
		 * This method are getting particular Job (GET{id})
		 * @param 	jobId
	     *          The id of the particular {@link Job}.
	     * @return 	job
	     * </p> 
	     * @throws ServiceException
	     * 			If any errors are encountered in the repository layer 
	     *			while retrieving data.
		 **/
		Optional<Job> findById(int jobId) throws ServiceException;
		
		/**
		* <p>
		* Update particular job (UPDATE)
		* @param	job
		*          	The particular Job {@link Job}.
		* @return 	Job
		* </p> 
		* @throws ServiceException
		* 			If any errors are encountered in the repository layer 
		*         	while saving data.
		**/
		Job update(Job job) throws ServiceException;
		
		/**
		 * <p>
		 * This method delete job by id (DELETE{id})
		 * @param 	jobId
		 * 			The id of the particular {@link Job}.
	     * @return 	void 
	     * </p> 
	     * @throws ServiceException
	     *   		If any errors are encountered in the repository layer
	     *    		while saving data.
		 **/
		void deleteById(int jobId) throws ServiceException;
	}
	

