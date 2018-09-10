package com.usel.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.usel.app.model.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {

	void save(Optional<Optional<Job>> of);
}