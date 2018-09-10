package com.usel.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.usel.app.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {

	void save(Optional<Optional<Vendor>> of);
}