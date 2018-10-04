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
		* @param 	Purchase
		* @return 	Purchase 
		* </p> 
		* @throws ServiceException
		* 			If any errors are encountered in the repository layer
		*           while saving data.
		**/
		Purchase create(Purchase purchase) throws ServiceException;
		
		/**
		 * <p>
		 * This method are getting particular purchase (GET{id})
		 * @param 	int purchaseId
	     *          The id of the particular {@link Purchase}.
	     * @return 	Optional<Purchase>
	     * </p> 
	     * @throws ServiceException
	     * 			If any errors are encountered in the repository layer 
	     *			while retrieving data.
		 **/
		Optional<Purchase> findById(int purchaseId) throws ServiceException;
		
		/**
		* <p>
		* Update particular purchase (UPDATE)
		* @param	Purchase
		*          	The particular Purchase {@link Purchase}.
		* @return 	Purchase
		* </p> 
		* @throws ServiceException
		* 			If any errors are encountered in the repository layer 
		*         	while saving data.
		**/
		Purchase update(Purchase purchase) throws ServiceException;
		
		/**
		 * <p>
		 * This method delete purchase by id (DELETE{id})
		 * @param 	int purchaseId
		 * 			The id of the particular {@link Purchase}.
	     * @return 	void 
	     * </p> 
	     * @throws ServiceException
	     *   		If any errors are encountered in the repository layer
	     *    		while saving data.
		 **/
		void deleteById(int purchaseId) throws ServiceException;
		
		/**
		 * <p>
		 * This method check for Purchase existsByPO
		 * @param 	int po
		 * 			The PO of the particular {@link Purchase}.
	     * @return 	boolean 
	     * </p> 
	     * @throws ServiceException
	     *   		If any errors are encountered in the repository layer
	     *    		while saving data.
		 **/
		boolean exist(int po) throws ServiceException;
	}