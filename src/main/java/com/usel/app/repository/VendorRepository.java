package com.usel.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.usel.app.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {
	
	public List<Vendor> getVendor();
	public void postVendor();
	public Vendor getVendorById(Vendor id);
	public void putVendorById(Vendor id);
	public void deleteVendorById(Vendor id);
	
}