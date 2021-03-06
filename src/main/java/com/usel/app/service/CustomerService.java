package com.usel.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.usel.app.model.Customer;
import com.usel.app.service.exception.ServiceException;

@Service
public interface CustomerService {
		
		/**
		 * <p>
		 * This method are getting all the customers (GET)
	     * @param	none
	     * @return	List of customers {@link Customer} 
	     * </p> 
	     * @throws ServiceException
	     * 			If any errors are encountered in the repository layer 
	     * 			while retrieving data.
		 **/
		List<Customer> findAll() throws ServiceException;
		
		/**
		* <p>
		* This method saving customers (POST)
		* @param 	Customer
		* @return 	Customer 
		* </p> 
		* @throws ServiceException
		* 			If any errors are encountered in the repository layer
		*           while saving data.
		**/
		Customer create(Customer customer) throws ServiceException;
		
		/**
		 * <p>
		 * This method are getting particular customer (GET{id})
		 * @param 	int customerId
	     *          The id of {@link Customer}.
	     * @return 	Optional<Customer>
	     * </p> 
	     * @throws ServiceException
	     * 			If any errors are encountered in the repository layer 
	     *			while retrieving data.
		 **/
		Optional<Customer> findById(int customerId) throws ServiceException;
		
		/**
		* <p>
		* Update particular customer (UPDATE)
		* @param	Customer
		*          	The particular Customer {@link Customer}.
		* @return 	Customer
		* </p> 
		* @throws ServiceException
		* 			If any errors are encountered in the repository layer 
		*         	while saving data.
		**/
		Customer update(Customer customer) throws ServiceException;
		
		/**
		 * <p>
		 * This method delete customer by id (DELETE{id})
		 * @param 	int customerId
		 * 			The id of the particular {@link Customer}.
	     * @return 	void 
	     * </p> 
	     * @throws ServiceException
	     *   		If any errors are encountered in the repository layer
	     *    		while saving data.
		 **/
		void deleteById(int customerId) throws ServiceException;
		
		/**
		 * <p>
		 * This method check for Customer existsById
		 * @param 	int id
		 * 			The id of the particular {@link Customer}.
	     * @return 	boolean 
	     * </p> 
	     * @throws ServiceException
	     *   		If any errors are encountered in the repository layer
	     *    		while saving data.
		 **/
		boolean exist(int id) throws ServiceException;
	}
	

