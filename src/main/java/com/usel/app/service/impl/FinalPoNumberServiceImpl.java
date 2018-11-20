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
		
		// fill up Purchase object with input data		
				Purchase purchase = new Purchase();
				Date date = new Date();
				/*User user = new User();
				Customer customer = new Customer();
				Vendor vendor = new Vendor();*/
				
				// TODO
				// line below must be uncomment after resolve Optional<> type
				purchase.setUser(userService.findById(user_id));
				purchase.setCustomer(customerService.findById(customer_id));
				purchase.setVendor(vendorService.findById(vendor_id));
				
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
		
				//return "AP 2296 - 0450";
	}
}