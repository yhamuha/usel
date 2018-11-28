package com.usel.app.service.impl;

import java.util.Date;
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

	PurchaseService purchaseService;
	CustomerService customerService;
	UserService userService;
	VendorService vendorService;
	
	@Override
	public String generateSaveAndReturnFinalPoNumber(int user_id, int customer_id, int vessel_id, int job_id,
			int vendor_id) throws ServiceException {
		
			Purchase purchase = new Purchase();

			Date dateCreated = new Date();
			Date dateUpdated = new Date();	
			
			User user = userService.findById(user_id).get();
			Customer customer = customerService.findById(customer_id).get();
			Vendor vendor = vendorService.findById(vendor_id).get();
			
			purchase.setUser(user);
			purchase.setCustomer(customer);
			purchase.setVendor(vendor);
			purchase.setFinalPoNumber(null);
			purchase.setCreatedAt(dateCreated);
			purchase.setUpdatedAt(dateUpdated);
			
			purchaseService.create(purchase);
									
			String finalPoNumber = user_id + " " + job_id + " - " + purchase.getPo();
												
			purchase.setFinalPoNumber(finalPoNumber);
												
			purchaseService.update(purchase);
				
																					//String finalPoNumber = user_id + "" + customer_id + "" + vessel_id + "" + job_id + "" + vendor_id;
			return finalPoNumber;
		
	}
}