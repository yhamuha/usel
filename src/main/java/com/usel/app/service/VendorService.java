package com.usel.app.service;

import java.util.List;
import java.util.Optional;
import com.usel.app.model.Vendor;
import com.usel.app.service.exception.ServiceException;

public interface VendorService {
		
		/**
		 * <p>
		 * This method are getting all the vendors (GET)
	     * @param	none
	     * @return	List of vendors 
	     * </p> 
	     * @throws ServiceException
	     * 			If any errors are encountered in the repository layer 
	     * 			while retrieving data.
		 **/
		List<Vendor> findAll() throws ServiceException;
		
		/**
		* <p>
		* This method saving vendors (POST)
		* @param 	Vendor
		* @return 	Vendor 
		* </p> 
		* @throws ServiceException
		* 			If any errors are encountered in the repository layer
		*           while saving data.
		**/
		Vendor create(Vendor vendor) throws ServiceException;
		
		/**
		 * <p>
		 * This method are getting particular vendor (GET{id})
		 * @param 	int vendorId
	     *          The id of the particular {@link Vendor}.
	     * @return 	Optional<Vendor>
	     * </p> 
	     * @throws ServiceException
	     * 			If any errors are encountered in the repository layer 
	     *			while retrieving data.
		 **/
		Optional<Vendor> findById(int vendorId) throws ServiceException;
		
		/**
		* <p>
		* Update particular vendor (UPDATE)
		* @param	Vendor
		*          	The particular Vendor {@link Vendor}.
		* @return 	Vendor
		* </p> 
		* @throws ServiceException
		* 			If any errors are encountered in the repository layer 
		*         	while saving data.
		**/
		Vendor update(Vendor vendor) throws ServiceException;
		
		/**
		 * <p>
		 * This method delete Vendor by id (DELETE{id})
		 * @param 	int vendorId
		 * 			The id of the particular {@link Vendor}.
	     * @return 	void 
	     * </p> 
	     * @throws ServiceException
	     *   		If any errors are encountered in the repository layer
	     *    		while saving data.
		 **/
		void deleteById(int vendorId) throws ServiceException;
		
	}
