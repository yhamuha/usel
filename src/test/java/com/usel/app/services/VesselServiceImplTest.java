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

import com.usel.app.model.Vessel;
import com.usel.app.repository.VesselRepository;
import com.usel.app.service.VesselService;
import com.usel.app.service.exception.ServiceException;
import com.usel.app.service.impl.VesselServiceImpl;

@RunWith(SpringRunner.class)
public class VesselServiceImplTest {

	@TestConfiguration
	static class VesselServiceImplTestContextConfiguration {

		@Bean
		VesselService VesselService() {
			return new VesselServiceImpl();
		}
	}

	@Autowired
	VesselService VesselService;

	@MockBean
	VesselRepository mockVesselRepository;

	int id;
	Optional<Vessel> vessel;

	@Before
	public void setUp() {
		Vessel vessel = new Vessel();
		Mockito.when(mockVesselRepository.save(vessel)).thenReturn(vessel);
		Mockito.when(mockVesselRepository.findById(id)).thenReturn(Optional.of(vessel));
	}

	@Test
	public void findAllShouldInvokeOnceUserRepositoryfindAllMethod() throws ServiceException {
		VesselService.findAll();
		Mockito.verify(mockVesselRepository, Mockito.times(1)).findAll();
	}

	@Test
	public void createShouldInvokeOnceUserRepositorySaveMethod() throws ServiceException {
		VesselService.create(vessel);
		Mockito.verify(mockVesselRepository, Mockito.times(1)).save(Optional.of(vessel));
	}

	@Test
	public void getUserByIdShouldNotReturnNull() throws ServiceException {
		Assert.assertNotNull(VesselService.findBy(id));
	}

	@Test
	public void getUserByEmailShouldInvokeOnceUserRepositoryfindByEmailMethod() throws ServiceException {
		VesselService.findBy(id);
		Mockito.verify(mockVesselRepository, Mockito.times(1)).findById(id);
	}

	@Test
	public void createByShouldInvokeOnceUserRepositorySaveMethod() throws ServiceException {
		VesselService.createBy(vessel);
		Mockito.verify(mockVesselRepository, Mockito.times(1)).save(Optional.of(vessel));
	}

	@Test
	public void deleteByShouldReturnNull() throws ServiceException {
		VesselService.deleteBy(id);
		Assert.assertNotNull(VesselService.findBy(id));
	}
}
