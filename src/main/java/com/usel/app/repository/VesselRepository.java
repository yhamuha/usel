package com.usel.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.usel.app.model.Vessel;

public interface VesselRepository extends JpaRepository<Vessel, Integer> {
	
	public List<Vessel> getVessel();
	public void postVessel();
	public Vessel getVesselById(Vessel id);
	public void putVesselById(Vessel id);
	public void deleteVesselById(Vessel id);
	
}