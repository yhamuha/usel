package com.usel.app.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.usel.app.model.Vendor;
import com.usel.app.repository.VendorRepository;
import com.usel.app.service.VendorService;
import com.usel.app.service.exception.ServiceException;

@Service
public class VendorServiceImpl implements VendorService {

	VendorRepository vendorRepository;
	
	public VendorServiceImpl(VendorRepository vendorRepository) { 
		this.vendorRepository = vendorRepository;
	}
	@Override
	public List<Vendor> findAll() throws ServiceException {
		return vendorRepository.findAll();
	}

	@Override
	public Vendor create(Vendor vendor) throws ServiceException {
		return vendorRepository.save(vendor);
	}

	@Override
	public Optional<Vendor> findById(int vendorId) throws ServiceException {
		return vendorRepository.findById(vendorId);
	}

	@Override
	public Vendor update(Vendor vendor) throws ServiceException {
		return vendorRepository.saveAndFlush(vendor);
	}

	@Override
	public void deleteById(int vendorId) throws ServiceException {
		vendorRepository.deleteById(vendorId);
	}

}
