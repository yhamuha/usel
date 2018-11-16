package com.usel.app.service.impl;

import java.util.Date;
import com.usel.app.model.Purchase;
import com.usel.app.service.PurchaseService;
import com.usel.app.service.exception.ServiceException;

public class FinalPoNumberServiceImpl {
	
		CustomerServiceImpl customerService;
		UserServiceImpl userService;
		VendorServiceImpl vendorService;
		PurchaseService purchaseService;
	
	public String generateSaveAndReturnFinalPoNumber(int user_id, int customer_id, int vessel_id, int job_id, int vendor_id) throws ServiceException {
		
		// fill up Purchase object		
		Purchase purchase = new Purchase();
		Date date = new Date();
		
		// TODO
		// line below must be uncomment after resolve Optional<> type
		//purchase.setCustomer((Optional)customerService.findById(customer_id));
		//purchase.setUser(userService.findById(user_id));
		//purchase.setVendor(vendorService.findById(vendor_id));
		
		// set finalPoNumber to null for this time
		purchase.setFinalPoNumber(null);
		purchase.setCreatedAt(date);
		purchase.setUpdatedAt(date);
		
		// save to db
		purchaseService.create(purchase);
		
		// after that we can generate finalPoNumber	
		String finalPoNumber = user_id + " " + job_id + " - " + purchase.getPo();
		
		// add final
		purchase.setFinalPoNumber(finalPoNumber);
		
		// update db. insert finalPoNumber
		purchaseService.update(purchase);
		
		//return
		return finalPoNumber;
		
	}
}
