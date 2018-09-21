package com.usel.app.services;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import com.usel.app.model.Vendor;
import com.usel.app.repository.VendorRepository;
import com.usel.app.service.exception.ServiceException;
import com.usel.app.service.impl.VendorServiceImpl;

@RunWith(SpringRunner.class)
public class VendorServiceImplTest {

	@Mock
	VendorRepository mockVendorRepository;

	@InjectMocks
	VendorServiceImpl vendorService;

	int id;
	Vendor vendor;
	List<Vendor> listVendor = new ArrayList<Vendor>();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		Vendor vendor = new Vendor();
		when(mockVendorRepository.save(vendor)).thenReturn(vendor);
		when(mockVendorRepository.findAll()).thenReturn(listVendor);
		when(mockVendorRepository.saveAndFlush(vendor)).thenReturn(vendor);
	}
	
	@Test
	public void findAllShouldInvokeOnceVendorRepositoryFindAllMethod() throws ServiceException {
		vendorService.findAll();
		verify(mockVendorRepository, times(1)).findAll();
	}
		
	@Test
	public void createShouldInvokeOnceVendorRepositorySaveMethod() throws ServiceException {
		vendorService.create(vendor);
		verify(mockVendorRepository, times(1)).save(vendor);
	}
	
	@Test
	public void  updateShouldInvokeOnceVendorRepositorySaveAndFlushMethod() throws ServiceException {
		vendorService.update(vendor);
		verify(mockVendorRepository, times(1)).saveAndFlush(vendor);
	}
	
	@Test
	public void findByIdShouldNotReturnNull() throws ServiceException {
		assertNotNull(vendorService.findById(id));
	}
	
	@Test
	public void deleteByIdInvokeOnceDeleteByIdRepositoryMethod() throws ServiceException {
		vendorService.deleteById(id);
		verify(mockVendorRepository, times(1)).deleteById(id);
	}
}
