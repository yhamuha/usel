package com.usel.app.service;

import com.usel.app.model.Customer;
import com.usel.app.model.Job;
import com.usel.app.model.User;
import com.usel.app.model.Vendor;
import com.usel.app.model.Vessel;
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
	String generateSaveAndReturnFinalPoNumber(User user, Customer customer, Vessel vessel, Job job, Vendor vendor) throws ServiceException;
}
