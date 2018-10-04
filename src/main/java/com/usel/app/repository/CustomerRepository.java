package com.usel.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.usel.app.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	public boolean existsById(int id);
}