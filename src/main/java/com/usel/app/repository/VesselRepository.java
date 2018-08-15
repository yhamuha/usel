package com.usel.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.usel.app.model.Vessel;

public interface VesselRepository extends JpaRepository<Vessel, Integer> {
}