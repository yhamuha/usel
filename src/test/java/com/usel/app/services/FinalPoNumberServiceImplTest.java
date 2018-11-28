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
import com.usel.app.model.Job;
import com.usel.app.model.Purchase;
import com.usel.app.model.User;
import com.usel.app.model.Vendor;
import com.usel.app.model.Vessel;
import com.usel.app.repository.PurchaseRepository;
import com.usel.app.service.FinalPoNumberService;
import com.usel.app.service.exception.ServiceException;
import com.usel.app.service.impl.CustomerServiceImpl;
import com.usel.app.service.impl.FinalPoNumberServiceImpl;
import com.usel.app.service.impl.JobServiceImpl;
import com.usel.app.service.impl.PurchaseServiceImpl;
import com.usel.app.service.impl.UserServiceImpl;
import com.usel.app.service.impl.VendorServiceImpl;
import com.usel.app.service.impl.VesselServiceImpl;

@RunWith(SpringRunner.class)
public class FinalPoNumberServiceImplTest {

	@Mock
	PurchaseRepository purchaseRepository;
	
	/*@Mock
	UserServiceImpl userService;
	
	@Mock
	CustomerServiceImpl customerService;
	
	@Mock
	VendorServiceImpl vendorService;
	
	@Mock
	JobServiceImpl jobService;
	
	@Mock
	VesselServiceImpl vesselService;
	
	@Mock
	Date dateCreated;
	
	@Mock
	Date dateUpdated;*/
	
	@InjectMocks
	FinalPoNumberServiceImpl finalPoNumberService;
	
	@InjectMocks
	PurchaseServiceImpl purchaseService;
	
	@InjectMocks
	Purchase purchase;
	
	/*@InjectMocks
	User user;
	
	@InjectMocks
	Customer customer;
	
	@InjectMocks
	Vendor vendor;
	
	@InjectMocks
	Vessel vessel;
	
	@InjectMocks
	Job job;*/
	
	@Before
	public void setUp() throws ServiceException {
		MockitoAnnotations.initMocks(this);
		
		when(purchaseRepository.save(purchase)).thenReturn(purchase);
		when(purchaseRepository.saveAndFlush(purchase)).thenReturn(purchase);
		
	}
	
	//@Test
		public void generateSaveAndReturnFinalPoNumberShouldReturnFinalPoNumber() throws ServiceException{
			
			/*when(userService.findById(1).get()).thenReturn(user);
			when(customerService.findById(1).get()).thenReturn(customer);
			when(vendorService.findById(10).get()).thenReturn(vendor);
			when(jobService.findById(1).get()).thenReturn(job);
		
			int user_id = 0, customer_id = 0, vendor_id = 0, job_id = 0, vessel_id = 0;
			
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
			
		    String actual = finalPoNumberService.generateSaveAndReturnFinalPoNumber(user_id, customer_id, vessel_id, job_id, vendor_id);		
									
			String expected = "00000";
			assertEquals(expected, actual);*/
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
			
			assertNotNull("createPurchaseShouldReturnNotNull", purchaseService.create(purchase));
	}
						
	//@Test
		public void createPurchaseShouldInvokeOnce() throws ServiceException {
			purchaseService.create(purchase);
			verify(purchaseRepository, times(1)).save(purchase);
		}
			
	//@Test
		public void updatePurchaseShouldInvokeOnce() throws ServiceException {
			purchaseService.update(purchase);
			verify(purchaseRepository, times(1)).saveAndFlush(purchase);
		}
	
}