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
	
	
	public String generateSaveAndReturnFinalPoNumber(User user_id, Customer customer_id, Vessel vessel_id, Job job_id, Vendor vendor_id, Purchase purchase_id_po) throws ServiceException {
		String finalPoNumber = null;
		
		// generate finalPoNumber string
		finalPoNumber = user_id.getShortName() + " " + job_id.getId() + " - " + purchase_id_po.getPo();
		
		// save purchase obj
		// =========================================================
		// construct Purchase object
		Purchase purchase = new Purchase();
		purchase.setUser(user_id);
		purchase.setCustomer(customer_id);
			// Vessel into Vessel !?
			   //purchase.setVessel
		    // Job into Job !?
		       //purchase.setJob
		purchase.setVendor(vendor_id);
		purchase.setFinalPoNumber(finalPoNumber);
		// save Purchase into DB
		PurchaseService purchaseService = null;
		purchaseService.create(purchase);
		
		//return generated finalPoNumber
		return finalPoNumber;
	}
}
