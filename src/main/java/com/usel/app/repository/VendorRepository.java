package com.usel.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.usel.app.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {
}