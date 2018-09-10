package com.usel.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.usel.app.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	void save(Optional<Optional<Customer>> optional);
}