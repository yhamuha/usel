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
		void createVessel(Optional<Vessel> vessel) throws ServiceException;
		
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
		Vessel findBy(int vesselId) throws ServiceException;
		
		/**
		* <p>
		* Create particular vessel (PUT)
		* @param	vessel
		*          	The id of the particular {@link Vessel}.
		* @return 	void
		* </p> 
		* @throws ServiceException
		* 			If any errors are encountered in the repository layer 
		*         	while saving data.
		**/
		void createBy (Optional<Vessel> vessel) throws ServiceException;
		
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
		void deleteBy(int vesselId) throws ServiceException;
		
	}
