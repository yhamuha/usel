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
import com.usel.app.model.Vessel;
import com.usel.app.repository.VesselRepository;
import com.usel.app.service.exception.ServiceException;
import com.usel.app.service.impl.VesselServiceImpl;

@RunWith(SpringRunner.class)
public class VesselServiceImplTest {

	@Mock
	VesselRepository mockVesselRepository;

	@InjectMocks
	VesselServiceImpl vesselService;

	int id;
	Vessel vessel;
	List<Vessel> listVessels = new ArrayList<Vessel>();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		Vessel vessel = new Vessel();
		when(mockVesselRepository.save(vessel)).thenReturn(vessel);
		when(mockVesselRepository.findAll()).thenReturn(listVessels);
		when(mockVesselRepository.saveAndFlush(vessel)).thenReturn(vessel);
	}

	@Test
	public void findAllShouldInvokeOnceUserRepositoryFindAllMethod() throws ServiceException {
		vesselService.findAll();
		verify(mockVesselRepository, times(1)).findAll();
	}

	@Test
	public void createShouldInvokeOnceUserRepositorySaveMethod() throws ServiceException {
		vesselService.create(vessel);
		verify(mockVesselRepository, times(1)).save(vessel);
	}
	
	@Test
	public void  updateShouldInvokeOnceVesselRepositorySaveAndFlushMethod() throws ServiceException {
		vesselService.update(vessel);
		verify(mockVesselRepository, times(1)).saveAndFlush(vessel);
	}

	@Test
	public void findByIdShouldNotReturnNull() throws ServiceException {
		assertNotNull(vesselService.findById(id));
	}
	
	@Test
	public void deleteByIdInvokeOnceDeleteByIdRepositoryMethod() throws ServiceException {
		vesselService.deleteById(id);
		verify(mockVesselRepository, times(1)).deleteById(id);
	}
}
