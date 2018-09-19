package com.usel.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.usel.app.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
}