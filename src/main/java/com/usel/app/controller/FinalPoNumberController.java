package com.usel.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usel.app.dto.PoNumberDTO;
import com.usel.app.service.FinalPoNumberService;
import com.usel.app.service.exception.ServiceException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class FinalPoNumberController {
	
	private final Logger LOG = LoggerFactory.getLogger(FinalPoNumberController.class);
	
	@Autowired
	FinalPoNumberService finalPoNumberService;
	
	@RequestMapping(value = "/finalponumber", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<PoNumberDTO> getPoNumber(@RequestParam(value = "user_id") int user_id,
			                                       @RequestParam(value = "customer_id") int customer_id,
			                                       @RequestParam(value = "vessel_id") int vessel_id,
			                                       @RequestParam(value = "job_id") int job_id,
			                                       @RequestParam(value = "vendor_id") int vendor_id){
		
		String poNumber = "";
		try {
			poNumber = finalPoNumberService.generateSaveAndReturnFinalPoNumber( user_id, 
																				customer_id, 
																				vessel_id, 
																				job_id, 
																				vendor_id);
		} catch (ServiceException e) {
			LOG.error("error in  getting po number: {}", e);
		}
		
		PoNumberDTO response = new PoNumberDTO();
		response.setPoNumber(poNumber); 
		
		return new ResponseEntity<PoNumberDTO>(response, HttpStatus.OK);	
	}
}