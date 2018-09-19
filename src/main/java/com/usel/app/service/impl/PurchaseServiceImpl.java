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
	
	public PurchaseServiceImpl(PurchaseRepository purchaseRepository) { 
		this.purchaseRepository = purchaseRepository;
	}
	
	
	@Override
	public List<Purchase> findAll() throws ServiceException {
		return purchaseRepository.findAll();
	}

	@Override
	public Purchase create(Purchase purchase) throws ServiceException {
		return purchaseRepository.save(purchase);
	}
	
	@Override
	public Purchase update(Purchase purchase) throws ServiceException {
		return purchaseRepository.saveAndFlush(purchase);
	}
	
	@Override
	public Optional<Purchase> findById(int purchaseId) throws ServiceException {
		return purchaseRepository.findById(purchaseId);
	}

	@Override
	public void deleteById(int purchaseId) throws ServiceException {
	}

}
