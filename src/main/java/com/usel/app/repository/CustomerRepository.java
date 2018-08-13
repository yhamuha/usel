package com.usel.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.usel.app.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	public List<Customer> getCustomers();
	public void postCustomers();
	public Customer getCustomerById(Customer id);
	public void putCustomerById(Customer id);
	public void deleteCustomerById(Customer id);
	
}