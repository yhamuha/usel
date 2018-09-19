package com.usel.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.usel.app.model.Vessel;
import com.usel.app.repository.VesselRepository;
import com.usel.app.service.VesselService;
import com.usel.app.service.exception.ServiceException;

@Service
public class VesselServiceImpl implements VesselService{

	VesselRepository vesselRepository;
	
	public VesselServiceImpl(VesselRepository vesselRepository) { 
		this.vesselRepository = vesselRepository;
	}
	
	@Override
	public List<Vessel> findAll() throws ServiceException {
		return vesselRepository.findAll();
	}

	@Override
	public Vessel create(Vessel vessel) throws ServiceException {
		return vesselRepository.save(vessel);
	}

	@Override
	public Optional<Vessel> findById(int vesselId) throws ServiceException {
		return vesselRepository.findById(vesselId);
	}

	@Override
	public void createById(int vesselId) throws ServiceException {
	}

	@Override
	public void deleteById(int vesselId) throws ServiceException {
	}

}
