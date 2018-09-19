package com.usel.app.services;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import com.usel.app.model.Purchase;
import com.usel.app.repository.PurchaseRepository;
import com.usel.app.service.exception.ServiceException;
import com.usel.app.service.impl.PurchaseServiceImpl;

@RunWith(SpringRunner.class)
public class PurchaseServiceImplTest {

	@Mock
	PurchaseRepository mockPurchaseRepository;

	@InjectMocks
	PurchaseServiceImpl purchaseService;

	int id;
	Purchase purchase;
	List<Purchase> listPurchases = new ArrayList<Purchase>();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		Purchase purchase = new Purchase();
		when(mockPurchaseRepository.save(purchase)).thenReturn(purchase);
		when(mockPurchaseRepository.findById(id)).thenReturn(Optional.of(purchase));
		when(mockPurchaseRepository.findAll()).thenReturn(listPurchases);
	}

	@Test
	public void findAllShouldInvokeOnceUserRepositoryFindAllMethod() throws ServiceException {
		purchaseService.findAll();
		verify(mockPurchaseRepository, times(1)).findAll();
	}

	@Test
	public void createShouldInvokeOncePurchaseRepositorySaveMethod() throws ServiceException {
		purchaseService.create(purchase);
		verify(mockPurchaseRepository, times(1)).save(purchase);
	}
	
	@Test
	public void getUserByIdShouldInvokeOnceUserRepositoryFindByIdMethod() throws ServiceException {
		purchaseService.findById(id);
		verify(mockPurchaseRepository, times(1)).findById(id);
	}
	
	@Test
	public void  updateShouldInvokeOncePurchaseRepositorySaveAndFlushMethod() throws ServiceException {
		purchaseService.update(purchase);
		verify(mockPurchaseRepository, times(1)).saveAndFlush(purchase);
	}
	
	@Test
	public void deleteByShouldReturnNull() throws ServiceException {
		purchaseService.deleteById(id);
		assertNotNull("deleteByIdShouldReturnNull", mockPurchaseRepository.findById(id));
	}
}
