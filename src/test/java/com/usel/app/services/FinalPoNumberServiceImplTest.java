package com.usel.app.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Date;
import static org.junit.Assert.*;
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
import com.usel.app.repository.PurchaseRepository;
import com.usel.app.service.FinalPoNumberService;
import com.usel.app.service.exception.ServiceException;
import com.usel.app.service.impl.FinalPoNumberServiceImpl;
import com.usel.app.service.impl.PurchaseServiceImpl;

@RunWith(SpringRunner.class)
public class FinalPoNumberServiceImplTest {

	@Mock
	PurchaseRepository purchaseRepository;
	
	@InjectMocks
	PurchaseServiceImpl purchaseService;
	//FinalPoNumberServiceImpl finalPoNumberService;
	Purchase purchase;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		when(purchaseRepository.save(purchase)).thenReturn(purchase);
		when(purchaseRepository.saveAndFlush(purchase)).thenReturn(purchase);
		
	}
	
	@Test
		public void generateSaveAndReturnFinalPoNumberShouldReturnString() throws ServiceException{
	
			int user_id = 0, customer_id = 0, vessel_id = 0, job_id = 0, vendor_id = 0;
			
			FinalPoNumberServiceImpl finalPoNumberService = new FinalPoNumberServiceImpl();
			String actual = finalPoNumberService.generateSaveAndReturnFinalPoNumber(user_id, customer_id, vessel_id, job_id, vendor_id);
			String expected = "00000";
			assertEquals(expected, actual);
	}
	
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
			
			when(purchaseRepository.save(purchase)).thenReturn(purchase);
			assertNotNull("createPurchaseShouldReturnNotNull", purchaseService.create(purchase));
	}
						
	@Test
		public void createPurchaseShouldInvokeOnce() throws ServiceException {
			purchaseService.create(purchase);
			verify(purchaseRepository, times(1)).save(purchase);
		}
			
	@Test
		public void updatePurchaseShouldInvokeOnce() throws ServiceException {
			purchaseService.update(purchase);
			verify(purchaseRepository, times(1)).saveAndFlush(purchase);
		}
	
}
