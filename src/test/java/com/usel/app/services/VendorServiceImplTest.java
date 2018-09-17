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

import com.usel.app.model.Vendor;
import com.usel.app.repository.VendorRepository;
import com.usel.app.service.VendorService;
import com.usel.app.service.exception.ServiceException;
import com.usel.app.service.impl.VendorServiceImpl;

@RunWith(SpringRunner.class)
public class VendorServiceImplTest {

	@TestConfiguration
	static class VendorServiceImplTestContextConfiguration {

		@Bean
		VendorService VendorService() {
			return new VendorServiceImpl();
		}
	}

	@Autowired
	VendorService VendorService;

	@MockBean
	VendorRepository mockVendorRepository;

	int id;
	Optional<Vendor> vendor;

	@Before
	public void setUp() {
		Vendor vendor = new Vendor();
		Mockito.when(mockVendorRepository.save(vendor)).thenReturn(vendor);
		Mockito.when(mockVendorRepository.findById(id)).thenReturn(Optional.of(vendor));
	}

	@Test
	public void findAllShouldInvokeOnceUserRepositoryfindAllMethod() throws ServiceException {
		VendorService.findAll();
		Mockito.verify(mockVendorRepository, Mockito.times(1)).findAll();
	}

	@Test
	public void createShouldInvokeOnceUserRepositorySaveMethod() throws ServiceException {
		VendorService.create(vendor);
		Mockito.verify(mockVendorRepository, Mockito.times(1)).save(Optional.of(vendor));
	}

	@Test
	public void getUserByIdShouldNotReturnNull() throws ServiceException {
		Assert.assertNotNull(VendorService.findBy(id));
	}

	@Test
	public void getUserByEmailShouldInvokeOnceUserRepositoryfindByEmailMethod() throws ServiceException {
		VendorService.findBy(id);
		Mockito.verify(mockVendorRepository, Mockito.times(1)).findById(id);
	}

	@Test
	public void createByShouldInvokeOnceUserRepositorySaveMethod() throws ServiceException {
		VendorService.createBy(vendor);
		Mockito.verify(mockVendorRepository, Mockito.times(1)).save(Optional.of(vendor));
	}

	@Test
	public void deleteByShouldReturnNull() throws ServiceException {
		VendorService.deleteBy(id);
		Assert.assertNotNull(VendorService.findBy(id));
	}
}
