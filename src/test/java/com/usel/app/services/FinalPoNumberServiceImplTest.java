package com.usel.app.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;
import java.util.Date;
import java.util.Optional;
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
import com.usel.app.service.CustomerService;
import com.usel.app.service.JobService;
import com.usel.app.service.UserService;
import com.usel.app.service.VendorService;
import com.usel.app.service.VesselService;
import com.usel.app.service.exception.ServiceException;
import com.usel.app.service.impl.FinalPoNumberServiceImpl;
import com.usel.app.service.impl.PurchaseServiceImpl;

@RunWith(SpringRunner.class)																																								
public class FinalPoNumberServiceImplTest {

	Purchase purchase;
	
	@InjectMocks																												
	FinalPoNumberServiceImpl finalPoNumberServiceImpl;																			

	@Mock
	PurchaseServiceImpl purchaseService;																						
	
	@Mock
	PurchaseRepository mockPurchaseRepository;																					
																																
	@Mock
	UserService mockUserService;

	@Mock
	CustomerService mockCustomerService;

	@Mock
	VesselService mockVesselService;

	@Mock
	JobService mockJobService;

	@Mock
	VendorService mockVendorService;

	@Before																														
	public void setUp() throws ServiceException {
		
		MockitoAnnotations.initMocks(this);																						
		
		when(mockPurchaseRepository.saveAndFlush(purchase)).thenReturn(purchase);												
		
	}

	@Test
	public void generateSaveAndReturnFinalPoNumber_ShouldReturnString() throws ServiceException{

		int user_id = 1, customer_id = 1, vessel_id = 1, job_id = 1, vendor_id = 1;																														
		
		Date currentDate = new Date();
		Date dateCreated = new Date();
		Date dateUpdated = new Date();
		String FinalPoNumber = "AP-0029-1440";
		
		User user = new User("User_name", "User_lastName", "email@email.com", "password", "User_shortName", true, dateCreated, dateUpdated);
		User user2 = new User("User_name2", "User_lastName", "email@email.com", "password", "User_shortName", true, dateCreated, dateUpdated);
		User user3 = new User("User_name3", "User_lastName", "email@email.com", "password", "User_shortName", true, dateCreated, dateUpdated);
		Customer customer = new Customer("Cust_name", 2, dateCreated, dateUpdated);																				
		Vessel vessel = new Vessel ("Vessel_name", dateCreated, dateUpdated);																					
		Job job = new Job("Job_desc", currentDate, "mmssale", true, dateCreated, dateUpdated);
		Vendor vendor = new Vendor ("Vendor_name", dateCreated, dateUpdated);
		Purchase purchase = new Purchase(user, customer, vendor, FinalPoNumber, dateCreated, dateUpdated);
		
		System.out.println(user);
		System.out.println(user2);
		System.out.println(user3);
		System.out.println(customer);
		System.out.println(vessel);
		System.out.println(job);
		System.out.println(vendor);
		System.out.println(purchase);
		
		Optional<User> optionalUser = Optional.of(user);																																																																	
		Optional<Customer> optionalCustomer = Optional.of(customer);
		Optional<Vessel> optionalVessel = Optional.of(vessel);
		Optional<Job> optionalJob = Optional.of(job);
		Optional<Vendor> optionalVendor = Optional.of(vendor);

		when((mockUserService.findById(1))).thenReturn(optionalUser);																																							
		when((mockCustomerService.findById(1))).thenReturn(optionalCustomer);																								
		when((mockVesselService.findById(1))).thenReturn(optionalVessel);
		when((mockJobService.findById(1))).thenReturn(optionalJob);
		when((mockVendorService.findById(1))).thenReturn(optionalVendor);
		when(purchaseService.create(purchase)).thenReturn(purchase);
		
		String actual = finalPoNumberServiceImpl.generateSaveAndReturnFinalPoNumber(user_id, customer_id, vessel_id, job_id, vendor_id);										
		
		
		
		String expected = "00000";																																
		assertEquals(expected, actual);
	}

	@Test
	public void createPurchase_ShouldReturnNotNull() throws ServiceException {

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

		when(mockPurchaseRepository.save(purchase)).thenReturn(purchase);
		assertNotNull("createPurchaseShouldReturnNotNull", purchaseService.create(purchase));
	}

	@Test
	public void createPurchase_ShouldInvokeOnce() throws ServiceException {
		purchaseService.create(purchase);
		verify(mockPurchaseRepository, times(1)).save(purchase);
	}

	@Test
	public void updatePurchase_ShouldInvokeOnce() throws ServiceException {
		purchaseService.update(purchase);
		verify(mockPurchaseRepository, times(1)).saveAndFlush(purchase);
	}

}
