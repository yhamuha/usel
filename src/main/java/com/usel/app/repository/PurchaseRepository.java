package com.usel.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.usel.app.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
	
	public List<Purchase> getPurchases();
	public void postPurchases();
	public void putJobById(Purchase po);
	
}