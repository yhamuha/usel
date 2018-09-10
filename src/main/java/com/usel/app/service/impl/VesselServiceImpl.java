package com.usel.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.usel.app.model.Vessel;
import com.usel.app.service.VesselService;
import com.usel.app.service.exception.ServiceException;

@Service
public class VesselServiceImpl implements VesselService{

	@Override
	public List<Vessel> findAll() throws ServiceException {
		return null;
	}

	@Override
	public void createVessel(Optional<Vessel> vessel) throws ServiceException {
	}

	@Override
	public Vessel findBy(int vesselId) throws ServiceException {
		return null;
	}

	@Override
	public void createBy(Optional<Vessel> vesselId) throws ServiceException {
	}

	@Override
	public void deleteBy(int vesselId) throws ServiceException {
	}

}
