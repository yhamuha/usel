package com.usel.app.service;

import java.util.List;

import com.usel.app.model.Customer;
import com.usel.app.service.exception.ServiceException;

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
		* @param 	customer
		* @return 	void 
		* </p> 
		* @throws ServiceException
		* 			If any errors are encountered in the repository layer
		*           while saving data.
		**/
		void createCustomer(Customer customer) throws ServiceException;
		
		/**
		 * <p>
		 * This method are getting particular customer (GET{id})
		 * @param 	customerId
	     *          The id of {@link Customer}.
	     * @return 	customer
	     * </p> 
	     * @throws ServiceException
	     * 			If any errors are encountered in the repository layer 
	     *			while retrieving data.
		 **/
		Customer findBy(int customerId) throws ServiceException;
		
		/**
		* <p>
		* Create particular customer (PUT)
		* @param	customerId
		*          	The id of the particular {@link Customer}.
		* @return 	void
		* </p> 
		* @throws ServiceException
		* 			If any errors are encountered in the repository layer 
		*         	while saving data.
		**/
		void createBy (int customerId) throws ServiceException;
		
		/**
		 * <p>
		 * This method delete customer by id (DELETE{id})
		 * @param 	customerId
		 * 			The id of the particular {@link Customer}.
	     * @return 	void 
	     * </p> 
	     * @throws ServiceException
	     *   		If any errors are encountered in the repository layer
	     *    		while saving data.
		 **/
		void deleteBy(int customerId) throws ServiceException;
	}
	
