package com.usel.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.usel.app.model.User;
import com.usel.app.service.exception.ServiceException;

@Service
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
		* @param 	User
		* @return 	User 
		* </p> 
		* @throws ServiceException
		* 			If any errors are encountered in the repository layer
		*           while saving data.
		**/
		User create(User user) throws ServiceException;
		
		/**
		 * <p>
		 * This method are getting particular user (GET{id})
		 * @param 	int userId
	     *          The id of the particular {@link User}.
	     * @return 	Optional<User>
	     * </p> 
	     * @throws ServiceException
	     * 			If any errors are encountered in the repository layer 
	     *			while retrieving data.
		 **/
		Optional<User> findById(int userId) throws ServiceException;
		
		/**
		* <p>
		* Update particular user (UPDATE)
		* @param	User
		*          	The particular User {@link User}.
		* @return 	User
		* </p> 
		* @throws ServiceException
		* 			If any errors are encountered in the repository layer 
		*         	while saving data.
		**/
		User update(User user) throws ServiceException;
		
		/**
		 * <p>
		 * This method delete user by id (DELETE{id})
		 * @param 	int userId
		 * 			The id of the particular {@link User}.
	     * @return 	void 
	     * </p> 
	     * @throws ServiceException
	     *   		If any errors are encountered in the repository layer
	     *    		while saving data.
		 **/
		void deleteById(int userId) throws ServiceException;
		
		/**
		 * <p>
		 * This method check for User existsByEmail
		 * @param 	String email
		 * 			The email of the particular {@link User}.
	     * @return 	boolean 
	     * </p> 
	     * @throws ServiceException
	     *   		If any errors are encountered in the repository layer
	     *    		while saving data.
		 **/
		boolean exist(String email) throws ServiceException;
}
