package com.usel.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.usel.app.model.Vendor;
import com.usel.app.service.VendorService;
import com.usel.app.service.exception.ServiceException;

@Service
public class VendorServiceImpl implements VendorService {

	@Override
	public List<Vendor> findAll() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createVendor(Vendor vendor) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vendor findBy(int vendorId) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createBy(int vendorId) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBy(int vendorId) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

}
