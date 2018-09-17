package com.usel.app.services;

import java.util.Optional;
import org.mockito.Mockito;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.usel.app.model.Purchase;
import com.usel.app.repository.PurchaseRepository;
import com.usel.app.service.PurchaseService;
import com.usel.app.service.exception.ServiceException;
import com.usel.app.service.impl.PurchaseServiceImpl;

@RunWith(SpringRunner.class)
public class PurchaseServiceImplTest {

	@TestConfiguration
	static class PurchaseServiceImplTestContextConfiguration {

		@Bean
		PurchaseService PurchaseService() {
			return new PurchaseServiceImpl();
		}
	}

	@Autowired
	PurchaseService PurchaseService;

	@MockBean
	PurchaseRepository mockPurchaseRepository;

	int id;
	Optional<Purchase> purchase;

	@Before
	public void setUp() {
		Purchase purchase = new Purchase();
		Mockito.when(mockPurchaseRepository.save(purchase)).thenReturn(purchase);
		Mockito.when(mockPurchaseRepository.findById(id)).thenReturn(Optional.of(purchase));
	}

	@Test
	public void findAllShouldInvokeOnceUserRepositoryfindAllMethod() throws ServiceException {
		PurchaseService.findAll();
		Mockito.verify(mockPurchaseRepository, Mockito.times(1)).findAll();
	}

	@Test
	public void createShouldInvokeOnceUserRepositorySaveMethod() throws ServiceException {
		PurchaseService.create(purchase);
		Mockito.verify(mockPurchaseRepository, Mockito.times(1)).save(Optional.of(purchase));
	}

	@Test
	public void getUserByIdShouldNotReturnNull() throws ServiceException {
		Assert.assertNotNull(PurchaseService.findBy(id));
	}

	@Test
	public void getUserByEmailShouldInvokeOnceUserRepositoryfindByEmailMethod() throws ServiceException {
		PurchaseService.findBy(id);
		Mockito.verify(mockPurchaseRepository, Mockito.times(1)).findById(id);
	}

	@Test
	public void createByShouldInvokeOnceUserRepositorySaveMethod() throws ServiceException {
		PurchaseService.createBy(purchase);
		Mockito.verify(mockPurchaseRepository, Mockito.times(1)).save(Optional.of(purchase));
	}

	@Test
	public void deleteByShouldReturnNull() throws ServiceException {
		PurchaseService.deleteBy(id);
		Assert.assertNotNull(PurchaseService.findBy(id));
	}
}
