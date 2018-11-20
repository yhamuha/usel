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

@RunWith(SpringRunner.class)
public class FinalPoNumberServiceImplTest {

	Purchase purchase;
	int user_id=1;
	int customer_id=1;
	int vessel_id=1;
	int job_id=1;
	int vendor_id=1;
	
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
	
	//@Test
		public void createPurchaseShouldReturnNotNull() throws ServiceException {
		
			Date date = new Date();
			User user = new User("Alex", "Johnson", "aj@gmail.com", "passw", "AJ", true, date, date);
			Customer customer = new Customer("Customer", 4050, date, date);
			Vendor vendor = new Vendor("Vendor", date, date);
			
			Purchase purchase = new Purchase();
			
			purchase.setUser(user);
			purchase.setCustomer(customer);
			purchase.setVendor(vendor);
			purchase.setCreatedAt(date);
			purchase.setUpdatedAt(date);
			
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
