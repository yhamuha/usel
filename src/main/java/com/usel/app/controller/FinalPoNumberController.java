package com.usel.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.usel.app.model.Customer;
import com.usel.app.service.CustomerService;
import com.usel.app.service.exception.ServiceException;

@RestController
@RequestMapping("/finalponumber")
public class FinalPoNumberController {
	
	private final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	CustomerService customerService;

		
	@RequestMapping(method = RequestMethod.POST)
	@PostMapping
	public ResponseEntity<Customer> create(@RequestBody Customer customer, UriComponentsBuilder ucBuilder) {
		LOG.info("creating new customer: {}", customer.getId());
		Customer createdCustomer;
		
		try {
			if (customerService.exist(customer.getId())){
			    LOG.info("a customer with name " + customer.getId() + " already exists");
			    return new ResponseEntity<Customer>(HttpStatus.CONFLICT);
			}
			createdCustomer = customerService.create(customer);
		} catch (ServiceException e) {
			LOG.error("a customer with name " + customer.getId() + " create failed", e);
			return new ResponseEntity<Customer>(HttpStatus.SERVICE_UNAVAILABLE);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/customers/{id}").buildAndExpand(createdCustomer.getId()).toUri());
        return new ResponseEntity<Customer>(headers, HttpStatus.CREATED);
	}
}