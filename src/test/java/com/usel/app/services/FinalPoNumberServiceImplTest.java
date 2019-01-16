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

	User user;
	Customer customer;
	Vessel vessel;
	Job job;
	Purchase purchase;
	Vendor vendor;
	Date dateCreated;
	Date dateUpdated;
	
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

	@InjectMocks
	FinalPoNumberServiceImpl finalPoNumberService;

	@InjectMocks
	PurchaseServiceImpl purchaseService;

	@Before
	public void setUp() throws ServiceException {
		MockitoAnnotations.initMocks(this);
		
		when(mockPurchaseRepository.save(purchase)).thenReturn(purchase);
		when(mockPurchaseRepository.saveAndFlush(purchase)).thenReturn(purchase);
		
	}

	@Test
	public void generateSaveAndReturnFinalPoNumberShouldReturnString() throws ServiceException{

		int user_id = 1, customer_id = 1, vessel_id = 1, job_id = 1, vendor_id = 1;
		
		Date myDate = new Date();

		user.setCreatedAt(myDate);		
		user.setEmail("email@email.com");
		user.setEnabled(true);
		user.setId(1);
		user.setLastName("lastName");
		user.setName("name");
		user.setPassword("password");
		user.setShortName("shortName");
		user.setUpdatedAt(myDate);
		
        
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
		
		String actual = finalPoNumberService.generateSaveAndReturnFinalPoNumber(user_id, customer_id, vessel_id, job_id, vendor_id);
		
		User user = mockUserService.findById(user_id).get();
		Customer customer = mockCustomerService.findById(customer_id).get();
		Vendor vendor = mockVendorService.findById(vendor_id).get();
		
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

		when(mockPurchaseRepository.save(purchase)).thenReturn(purchase);
		assertNotNull("createPurchaseShouldReturnNotNull", purchaseService.create(purchase));
	}

	@Test
	public void createPurchaseShouldInvokeOnce() throws ServiceException {
		purchaseService.create(purchase);
		verify(mockPurchaseRepository, times(1)).save(purchase);
	}

	@Test
	public void updatePurchaseShouldInvokeOnce() throws ServiceException {
		purchaseService.update(purchase);
		verify(mockPurchaseRepository, times(1)).saveAndFlush(purchase);
	}

}
