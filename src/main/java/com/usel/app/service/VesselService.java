package com.usel.app.service;

import java.util.List;
import java.util.Optional;
import com.usel.app.model.Vessel;
import com.usel.app.service.exception.ServiceException;

public interface VesselService {
		
		/**
		 * <p>
		 * This method are getting all the vessels (GET)
	     * @param	none
	     * @return	List of vessels 
	     * </p> 
	     * @throws ServiceException
	     * 			If any errors are encountered in the repository layer 
	     * 			while retrieving data.
		 **/
		List<Vessel> findAll() throws ServiceException;
		
		/**
		* <p>
		* This method saving vessels (POST)
		* @param 	vessel
		* @return 	void 
		* </p> 
		* @throws ServiceException
		* 			If any errors are encountered in the repository layer
		*           while saving data.
		**/
		Vessel create(Vessel vessel) throws ServiceException;
		
		/**
		 * <p>
		 * This method are getting particular vessel (GET{id})
		 * @param 	vesselId
	     *          The id of the particular {@link Vessel}.
	     * @return 	vessel
	     * </p> 
	     * @throws ServiceException
	     * 			If any errors are encountered in the repository layer 
	     *			while retrieving data.
		 **/
		Optional<Vessel> findById(int vesselId) throws ServiceException;
		
		/**
		* <p>
		* Update particular vessel (UPDATE)
		* @param	vessel
		*          	The particular Vessel {@link Vessel}.
		* @return 	Vessel
		* </p> 
		* @throws ServiceException
		* 			If any errors are encountered in the repository layer 
		*         	while saving data.
		**/
		Vessel update(Vessel vessel) throws ServiceException;
		
		/**
		 * <p>
		 * This method delete Vessel by id (DELETE{id})
		 * @param 	vesselId
		 * 			The id of the particular {@link Vessel}.
	     * @return 	void 
	     * </p> 
	     * @throws ServiceException
	     *   		If any errors are encountered in the repository layer
	     *    		while saving data.
		 **/
		void deleteById(int vesselId) throws ServiceException;
		
	}
