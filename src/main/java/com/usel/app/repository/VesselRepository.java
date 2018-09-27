package com.usel.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.usel.app.model.Vessel;

@Repository
public interface VesselRepository extends JpaRepository<Vessel, Integer> {
}