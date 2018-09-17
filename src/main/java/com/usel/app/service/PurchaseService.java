package com.usel.app.service;

import java.util.List;
import java.util.Optional;

import com.usel.app.model.Purchase;
import com.usel.app.service.exception.ServiceException;

public interface PurchaseService {
		
		/**
		 * <p>
		 * This method are getting all the purchases (GET)
	     * @param	none
	     * @return	List of purchases 
	     * </p> 
	     * @throws ServiceException
	     * 			If any errors are encountered in the repository layer 
	     * 			while retrieving data.
		 **/
		List<Purchase> findAll() throws ServiceException;
		
		/**
		* <p>
		* This method saving purchases (POST)
		* @param 	purchase
		* @return 	void 
		* </p> 
		* @throws ServiceException
		* 			If any errors are encountered in the repository layer
		*           while saving data.
		**/
		void create(Optional<Purchase> purchase) throws ServiceException;
		
		/**
		 * <p>
		 * This method are getting particular purchase (GET{id})
		 * @param 	purchaseId
	     *          The id of the particular {@link Purchase}.
	     * @return 	purchase
	     * </p> 
	     * @throws ServiceException
	     * 			If any errors are encountered in the repository layer 
	     *			while retrieving data.
		 **/
		Purchase findBy(int purchaseId) throws ServiceException;
		
		/**
		* <p>
		* Create particular purchase (PUT)
		* @param	purchase
		*          	The id of the particular {@link Purchase}.
		* @return 	void
		* </p> 
		* @throws ServiceException
		* 			If any errors are encountered in the repository layer 
		*         	while saving data.
		**/
		void createBy (Optional<Purchase> purchase) throws ServiceException;
		
		/**
		 * <p>
		 * This method delete purchase by id (DELETE{id})
		 * @param 	purchaseId
		 * 			The id of the particular {@link Purchase}.
	     * @return 	void 
	     * </p> 
	     * @throws ServiceException
	     *   		If any errors are encountered in the repository layer
	     *    		while saving data.
		 **/
		void deleteBy(int purchaseId) throws ServiceException;

	}