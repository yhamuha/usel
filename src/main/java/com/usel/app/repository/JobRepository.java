package com.usel.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.usel.app.model.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {
}