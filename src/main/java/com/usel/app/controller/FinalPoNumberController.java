package com.usel.app.controller;

import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.usel.app.model.Customer;
import com.usel.app.model.Job;
import com.usel.app.model.Purchase;
import com.usel.app.model.User;
import com.usel.app.model.Vendor;
import com.usel.app.model.Vessel;
import com.usel.app.service.CustomerService;
import com.usel.app.service.FinalPoNumberService;
import com.usel.app.service.PurchaseService;
import com.usel.app.service.exception.ServiceException;

@RestController
@RequestMapping(value = "/finalponumber/", method = RequestMethod.POST, consumes="application/json")
public class FinalPoNumberController {
	
	private final Logger LOG = LoggerFactory.getLogger(FinalPoNumberController.class);
	
	@Autowired
    PurchaseService purchaseService;
	
public String generateSaveAndReturnFinalPoNumber(@RequestBody User user, Customer customer, 
		Vessel vessel, Job job, Vendor vendor, Purchase purchase, UriComponentsBuilder ucBuilder) {
    
	LOG.info("Creating Purchase : {}", purchase);
    
    FinalPoNumberService finalNumberService = null;
	String response = null;
	
		try {
			if (purchaseService.exist(purchase.getPo())) {
				LOG.error("Unable to create. A Purchase with name {} already exist", purchase.getPo());
				return new ResponseEntity("Unable to create. A Purchase with name " + 
				purchase.getPo() + " already exist.",HttpStatus.CONFLICT);
			}
		} catch (ServiceException e1) {
			e1.printStackTrace();
		}
	
		try {
			response = finalNumberService.generateSaveAndReturnFinalPoNumber(user, customer, vessel, job,  vendor);
			return response;
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(ucBuilder.path("").buildAndExpand(user.getId()).toUri());
		
	    headers.setLocation(ucBuilder.path("/purchase/{id}").buildAndExpand(purchase.getPo()).toUri());
	    return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
}
