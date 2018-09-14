package com.usel.app.service;

import java.util.List;
import java.util.Optional;

import com.usel.app.model.User;
import com.usel.app.service.exception.ServiceException;

public interface UserService {
		
		/**
		 * <p>
		 * This method are getting all the users (GET)
	     * @param	none
	     * @return	List of users 
	     * </p> 
	     * @throws ServiceException
	     * 			If any errors are encountered in the repository layer 
	     * 			while retrieving data.
		 **/
		List<User> findAll() throws ServiceException;
		
		/**
		* <p>
		* This method saving users (POST)
		* @param 	user
		* @return 	void 
		* </p> 
		* @throws ServiceException
		* 			If any errors are encountered in the repository layer
		*           while saving data.
		**/
		void createCustomer(Optional<User> user) throws ServiceException;
		
		/**
		 * <p>
		 * This method are getting particular user (GET{id})
		 * @param 	userId
	     *          The id of the particular {@link User}.
	     * @return 	purchase
	     * </p> 
	     * @throws ServiceException
	     * 			If any errors are encountered in the repository layer 
	     *			while retrieving data.
		 **/
		User findBy(int userId) throws ServiceException;
		
		/**
		* <p>
		* Create particular user (PUT)
		* @param	userId
		*          	The id of the particular user {@link User}.
		* @return 	void
		* </p> 
		* @throws ServiceException
		* 			If any errors are encountered in the repository layer 
		*         	while saving data.
		**/
		void createBy(int userId) throws ServiceException;
		
		/**
		 * <p>
		 * This method delete user by id (DELETE{id})
		 * @param 	userId
		 * 			The id of the particular {@link User}.
	     * @return 	void 
	     * </p> 
	     * @throws ServiceException
	     *   		If any errors are encountered in the repository layer
	     *    		while saving data.
		 **/
		void deleteBy(int userId) throws ServiceException;
		
		/**
		 * <p>
		 * This method checking user on enable/disable status
		 * @param 	userId
	     *          The {@link User}.
	     * @return true (when user is enabled) / false (when user is disabled)
	     * </p> 
	     * @throws ServiceException
	     *         	If any errors are encountered in the repository layer 
	     *         	while retrieving data.
		 **/
		boolean isEnabled(User userId) throws ServiceException;

	}
