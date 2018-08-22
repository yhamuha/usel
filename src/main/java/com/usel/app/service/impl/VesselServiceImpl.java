package com.usel.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.usel.app.model.Vessel;
import com.usel.app.service.VesselService;
import com.usel.app.service.exception.ServiceException;

@Service
public class VesselServiceImpl implements VesselService{

	@Override
	public List<Vessel> findAll() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createVessel(Vessel vessel) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vessel findBy(int vesselId) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createBy(int vesselId) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBy(int vesselId) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

}
