package com.usel.app.service;

import com.usel.app.service.exception.ServiceException;

public interface FinalPoNumberService {
	/**
	 * <p>
	 * This method are generating, saving into DB and returning finalPoNumber
     * @param	User.id (User.shortName), Customer.id, Vessel.id, Job.id, Vendor.id, Purchase.po
     * @return	String of generated like (AP 2296 - 0450) 
     * </p> 
     * @throws ServiceException
     * 			If any errors are encountered in the repository layer 
     * 			while retrieving data.
	 **/
	String generateSaveAndReturnFinalPoNumber(int user_id, int customer_id, int vessel_id, int job_id, int vendor_id) throws ServiceException;
}
