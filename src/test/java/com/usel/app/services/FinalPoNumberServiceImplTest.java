package com.usel.app.services;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import com.usel.app.model.Purchase;
import com.usel.app.repository.CustomerRepository;
import com.usel.app.repository.PurchaseRepository;
import com.usel.app.repository.UserRepository;
import com.usel.app.repository.VendorRepository;
import com.usel.app.service.exception.ServiceException;
import com.usel.app.service.impl.CustomerServiceImpl;
import com.usel.app.service.impl.FinalPoNumberServiceImpl;
import com.usel.app.service.impl.PurchaseServiceImpl;
import com.usel.app.service.impl.UserServiceImpl;
import com.usel.app.service.impl.VendorServiceImpl;

@RunWith(SpringRunner.class)
public class FinalPoNumberServiceImplTest {

	@Mock
	PurchaseRepository mockPurchaseRepository;
	CustomerRepository mockCustomerRepository;
	UserRepository mockUserRepository;
	VendorRepository mockVendorRepository;

	@InjectMocks
	CustomerServiceImpl customerService;
	UserServiceImpl userService;
	VendorServiceImpl vendorService;
	PurchaseServiceImpl purchaseService;
	FinalPoNumberServiceImpl finalPoNumberService;

	int id;
	Purchase purchase;
	int user_id = 1;
	int customer_id = 1;
	int vessel_id =1;
	int job_id = 1;
	int vendor_id;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		Purchase purchase = new Purchase();
		when(mockPurchaseRepository.save(purchase)).thenReturn(purchase);
		when(mockPurchaseRepository.saveAndFlush(purchase)).thenReturn(purchase);
		
		// TODO
		// line below must be uncomment after resolve Optional<> type
		//when(mockPurchaseRepository.findById(id)).thenReturn(purchase);
		
	}

	@Test
	public void generateSaveAndReturnFinalPoNumberShouldInvokeOnce() throws ServiceException {
		finalPoNumberService.generateSaveAndReturnFinalPoNumber(user_id, customer_id, vessel_id, job_id, vendor_id);
		verify(mockPurchaseRepository, times(1)).save(purchase);
	}
	
	@Test
	public void generateSaveAndReturnFinalPoNumberShouldNotReturnNull() throws ServiceException {
		assertNotNull(purchaseService.findById(id));
	}
	
}
