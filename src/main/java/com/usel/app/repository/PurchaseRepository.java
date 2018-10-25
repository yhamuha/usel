package com.usel.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.usel.app.model.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
	public boolean existsByPo(int po);
}