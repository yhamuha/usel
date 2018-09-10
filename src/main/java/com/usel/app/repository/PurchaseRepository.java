package com.usel.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.usel.app.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

	void save(Optional<Optional<Purchase>> of);
}