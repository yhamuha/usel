package com.usel.app.service.impl;

import com.usel.app.model.Customer;
import com.usel.app.model.Job;
import com.usel.app.model.Purchase;
import com.usel.app.model.User;
import com.usel.app.model.Vendor;
import com.usel.app.model.Vessel;
import com.usel.app.service.PurchaseService;
import com.usel.app.service.exception.ServiceException;

public class FinalPoNumberServiceImpl {
	
	
	public String generateSaveAndReturnFinalPoNumber(User user_id, Customer customer_id, Vessel vessel_id, Job job_id, Vendor vendor_id) throws ServiceException {
		
		// save purchase obj
				// =========================================================
				// construct Purchase object
				Purchase purchase = new Purchase();
				purchase.setUser(user_id);
				purchase.setCustomer(customer_id);
				// no purchase.setVessel setter
				// no purchase.setJob setter
				purchase.setVendor(vendor_id);
				//set finalPoNumber to null while because we haven't this value now
				purchase.setFinalPoNumber(null);
				
				// save Purchase into DB
				PurchaseService purchaseService = null;
				purchaseService.create(purchase);
		
		// generate finalPoNumber string
		String finalPoNumber = user_id.getShortName() + " " + job_id.getId() + " - " + purchase.getPo();
		
		// update Purchase.finalPoNumber to Purchase entity
		purchase.setFinalPoNumber(finalPoNumber);
		purchaseService.update(purchase);
		
		//return generated finalPoNumber
		return finalPoNumber;
	}
}
