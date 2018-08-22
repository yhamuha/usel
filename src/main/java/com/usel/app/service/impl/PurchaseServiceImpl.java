package com.usel.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.usel.app.model.Purchase;
import com.usel.app.service.PurchaseService;
import com.usel.app.service.exception.ServiceException;

@Service
public class PurchaseServiceImpl implements PurchaseService{

	@Override
	public List<Purchase> findAll() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createCustomer(Purchase purchase) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Purchase findBy(int purchaseId) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createBy(int purchaseId) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBy(int purchaseId) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

}
