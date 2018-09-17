package com.usel.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.usel.app.model.Purchase;
import com.usel.app.repository.PurchaseRepository;
import com.usel.app.service.PurchaseService;
import com.usel.app.service.exception.ServiceException;

@Service
public class PurchaseServiceImpl implements PurchaseService{

	PurchaseRepository purchaseRepository;
	
	@Override
	public List<Purchase> findAll() throws ServiceException {
		return null;
	}

	@Override
	public void create(Optional<Purchase> purchase) throws ServiceException {
	}
	
	@Override
	public Purchase findBy(int purchaseId) throws ServiceException {
		return null;
	}

	@Override
	public void createBy(Optional<Purchase> purchaseId) throws ServiceException {
	}

	@Override
	public void deleteBy(int purchaseId) throws ServiceException {
	}

}
