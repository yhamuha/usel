package com.usel.app.service;

import java.util.List;

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
		List<Purchase> createCustomer(Purchase purchase) throws ServiceException;
		
		/**
		 * <p>
		 * This method are getting particular purchase (GET{id})
		 * @param 	purchaseId
	     *          The id of the particular purchase {@link Purchase}.
	     * @return 	List of purchases
	     * </p> 
	     * @throws ServiceException
	     * 			If any errors are encountered in the repository layer 
	     *			while retrieving data.
		 **/
		Purchase findBy(int purchaseId) throws ServiceException;
		
		/**
		* <p>
		* Create particular purchase (PUT)
		* @param	purchaseId
		*          	The id of the particular purchase {@link Purchase}.
		* @return 	void
		* </p> 
		* @throws ServiceException
		* 			If any errors are encountered in the repository layer 
		*         	while saving data.
		**/
		Purchase createBy (int purchaseId) throws ServiceException;
		
		/**
		 * <p>
		 * This method delete purchase by id (DELETE{id})
		 * @param 	purchaseId
		 * 			The id of the particular purchase {@link Purchase}.
	     * @return 	void 
	     * </p> 
	     * @throws ServiceException
	     *   		If any errors are encountered in the repository layer
	     *    		while saving data.
		 **/
		void deleteBy(int purchaseId) throws ServiceException;
	}