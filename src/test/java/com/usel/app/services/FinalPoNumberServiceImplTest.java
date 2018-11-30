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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import com.usel.app.model.Customer;
import com.usel.app.model.Job;
import com.usel.app.model.Purchase;
import com.usel.app.model.User;
import com.usel.app.model.Vendor;
import com.usel.app.model.Vessel;
import com.usel.app.repository.PurchaseRepository;
import com.usel.app.service.CustomerService;
import com.usel.app.service.FinalPoNumberService;
import com.usel.app.service.JobService;
import com.usel.app.service.UserService;
import com.usel.app.service.VendorService;
import com.usel.app.service.VesselService;
import com.usel.app.service.exception.ServiceException;
import com.usel.app.service.impl.FinalPoNumberServiceImpl;
import com.usel.app.service.impl.PurchaseServiceImpl;

@RunWith(SpringRunner.class)
public class FinalPoNumberServiceImplTest {

	User user;
	Customer customer;
	Vessel vessel;
	Job job;
	Purchase purchase;
	Vendor vendor;
	Date dateCreated;
	Date dateUpdated;
	
	@Mock
	PurchaseRepository purchaseRepository;

	@Mock
	UserService userService;

	@Mock
	CustomerService customerService;

	@Mock
	VesselService vesselService;

	@Mock
	JobService jobService;

	@Mock
	VendorService vendorService;

	@InjectMocks
	FinalPoNumberServiceImpl finalPoNumberService;

	@InjectMocks
	PurchaseServiceImpl purchaseService;

	@Before
	public void setUp() throws ServiceException {
		MockitoAnnotations.initMocks(this);

		when(purchaseRepository.save(purchase)).thenReturn(purchase);
		when(purchaseRepository.saveAndFlush(purchase)).thenReturn(purchase);

		when((userService.findById(1).get())).thenReturn(user);
		when((customerService.findById(1).get())).thenReturn(customer);
		when((vesselService.findById(1).get())).thenReturn(vessel);
		when((jobService.findById(1).get())).thenReturn(job);
		when((vendorService.findById(1).get())).thenReturn(vendor);

	}

	@Test
	public void generateSaveAndReturnFinalPoNumberShouldReturnString() throws ServiceException{

		/*int user_id = 0, customer_id = 0, vessel_id = 0, job_id = 0, vendor_id = 0;
		
		FinalPoNumberServiceImpl finalPoNumberService = new FinalPoNumberServiceImpl();
		String actual = finalPoNumberService.generateSaveAndReturnFinalPoNumber(user_id, customer_id, vessel_id, job_id, vendor_id);*/
	
		
		purchase.setUser(user);
		purchase.setCustomer(customer);
		purchase.setVendor(vendor);
		purchase.setFinalPoNumber(null);
		purchase.setCreatedAt(dateCreated);
		purchase.setUpdatedAt(dateUpdated);
		
		purchaseService.create(purchase);
								
		String finalPoNumber = user_id + " " + job_id + " - " + purchase.getPo();
											
		purchase.setFinalPoNumber(finalPoNumber);
											
		purchaseService.update(purchase);*/
			
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
