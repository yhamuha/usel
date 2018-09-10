package com.usel.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.usel.app.model.Vessel;

public interface VesselRepository extends JpaRepository<Vessel, Integer> {

	void save(Optional<Optional<Vessel>> of);
}