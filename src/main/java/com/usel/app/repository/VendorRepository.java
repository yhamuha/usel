package com.usel.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.usel.app.model.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer> {
}