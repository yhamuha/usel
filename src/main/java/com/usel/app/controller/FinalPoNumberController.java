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
import com.usel.app.service.CustomerService;
import com.usel.app.service.FinalPoNumberService;
import com.usel.app.service.exception.ServiceException;

@RestController
@RequestMapping("/finalponumber")
public class FinalPoNumberController {
	
	private final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(method=RequestMethod.POST,consumes="application/json")
    @ResponseBody
    public String generateSaveAndReturn(User user_id, Job job_id, Purchase purchase_id_po ) {
	
		FinalPoNumberService finalNumberService = null;
		String response = null;
		
			try {
				response = finalNumberService.generateSaveAndReturnFinalPoNumber(user_id, null, null, job_id, null, purchase_id_po);
			
			} catch (ServiceException e) {
				e.printStackTrace();
			}
			return response;
		        
    }
        
}