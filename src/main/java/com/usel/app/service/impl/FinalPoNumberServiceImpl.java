package com.usel.app.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usel.app.model.Customer;
import com.usel.app.model.Purchase;
import com.usel.app.model.User;
import com.usel.app.model.Vendor;
import com.usel.app.service.CustomerService;
import com.usel.app.service.FinalPoNumberService;
import com.usel.app.service.PurchaseService;
import com.usel.app.service.UserService;
import com.usel.app.service.VendorService;
import com.usel.app.service.exception.ServiceException;

@Service
public class FinalPoNumberServiceImpl implements FinalPoNumberService{																						

	@Autowired
	PurchaseService purchaseService;	
	@Autowired
	CustomerService customerService;
	@Autowired
	UserService userService;
	@Autowired
	VendorService vendorService;
	
	@Override
	public String generateSaveAndReturnFinalPoNumber(int user_id, int customer_id, int vessel_id, int job_id, int vendor_id) throws ServiceException {
		
			User user = new User();																															
			Customer customer = new Customer();
			Vendor vendor = new Vendor();

			Date dateCreated = new Date();
			Date dateUpdated = new Date();	
			
			user = userService.findById(user_id).get();																										
			customer = customerService.findById(customer_id).get();
			vendor = vendorService.findById(vendor_id).get();
			
			Purchase purchase = new Purchase(user, customer, vendor, null, dateCreated, dateUpdated);
			
			purchaseService.create(purchase);																												
									
			String finalPoNumber = user_id + " " + job_id + " - " + purchase.getPo();
												
			purchase.setFinalPoNumber(finalPoNumber);
												
			purchaseService.update(purchase);
				
			finalPoNumber = user_id + "" + customer_id + "" + vessel_id + "" + job_id + "" + vendor_id;
			return finalPoNumber;
		
	}
}