package com.usel.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.usel.app.model.Vendor;
import com.usel.app.service.VendorService;
import com.usel.app.service.exception.ServiceException;

@Service
public class VendorServiceImpl implements VendorService {

	@Override
	public List<Vendor> findAll() throws ServiceException {
		return null;
	}

	@Override
	public void createVendor(Optional<Vendor> vendor) throws ServiceException {
	}

	@Override
	public Vendor findBy(int vendorId) throws ServiceException {
		return null;
	}

	@Override
	public void createBy(Optional<Vendor> vendorId) throws ServiceException {
	}

	@Override
	public void deleteBy(int vendorId) throws ServiceException {
	}

}
