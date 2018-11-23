package com.usel.app.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;
import java.util.Date;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import com.usel.app.model.Customer;
import com.usel.app.model.Purchase;
import com.usel.app.model.User;
import com.usel.app.model.Vendor;
import com.usel.app.service.PurchaseService;
import com.usel.app.service.exception.ServiceException;
import com.usel.app.service.impl.FinalPoNumberServiceImpl;
import static org.mockito.Matchers.*;
import static org.mockito.Matchers.anyString;

@RunWith(SpringRunner.class)
public class FinalPoNumberServiceImplTest {

	Purchase purchase;
	
	@Mock
	PurchaseService purchaseService;
	
	@InjectMocks
	FinalPoNumberServiceImpl finalPoNumberService;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		try {
			when(purchaseService.create(purchase)).thenReturn(purchase);
		} catch (ServiceException e1) {
			e1.printStackTrace();
		}
		
		try {
			when(purchaseService.update(purchase)).thenReturn(purchase);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
	}
	
	/*@Test
	public void generateSaveAndReturnFinalPoNumberShouldReturnString() throws ServiceException{
	
		int user_id=1;
		int customer_id=1;
		int vessel_id=1;
		int job_id=1;
		int vendor_id=1;
		
	try {
		String finalPoNumber = null;
		when (finalPoNumberService.generateSaveAndReturnFinalPoNumber(user_id, 
				customer_id, vessel_id,	job_id,	vendor_id)).thenReturn(finalPoNumber);
	} catch (ServiceException e) {
		e.printStackTrace();
	}
	
	verify(finalPoNumberService.generateSaveAndReturnFinalPoNumber(user_id, customer_id, vessel_id,	job_id,	vendor_id));
	}*/
	
	@Test
		public void createPurchaseShouldReturnNotNull() throws ServiceException {
		
			Date dateCreated = new Date();
			Date dateUpdated = new Date();
			User user = new User("Alex", "Johnson", "aj@gmail.com", "passw", "AJ", true, dateCreated, dateUpdated);
			Customer customer = new Customer("Customer", 4050, dateCreated, dateUpdated);
			Vendor vendor = new Vendor("Vendor", dateCreated, dateUpdated);
			
			Purchase purchase = new Purchase();
			
			purchase.setUser(user);
			purchase.setCustomer(customer);
			purchase.setVendor(vendor);
			purchase.setCreatedAt(dateCreated);
			purchase.setUpdatedAt(dateUpdated);
			
			//when(purchaseService.create(purchase)).thenReturn(purchase);
			assertNotNull(purchaseService.create(purchase));
			
	}
						
	@Test
		public void createPurchaseShouldInvokeOnce() throws ServiceException {
			purchaseService.create(purchase);
			verify(purchaseService, times(1)).create(purchase);
		}
			
	@Test
		public void updatePurchaseShouldInvokeOnce() throws ServiceException {
			purchaseService.update(purchase);
			verify(purchaseService, times(1)).update(purchase);
		}
	
}
