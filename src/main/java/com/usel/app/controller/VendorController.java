package com.usel.app.controller;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.usel.app.model.Vendor;
import com.usel.app.service.VendorService;
import com.usel.app.service.exception.ServiceException;


@RestController
@RequestMapping("/vendors")
public class VendorController {
	
	private final Logger LOG = LoggerFactory.getLogger(VendorController.class);
	
	@Autowired
	VendorService vendorService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Vendor>> getAll() {
		LOG.info("getting all vendors");
		
		List<Vendor> vendors = null;
		try {
			vendors = vendorService.findAll();
			if (vendors == null || vendors.isEmpty()){
	            LOG.info("no vendors found");
	            return new ResponseEntity<List<Vendor>>(HttpStatus.NO_CONTENT);
	        }
		} catch (ServiceException e) {
			LOG.error("getting all surveys failed", e);
			return new ResponseEntity<List<Vendor>>(HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<List<Vendor>>(vendors, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@PostMapping
	public ResponseEntity<Vendor> create(@RequestBody Vendor vendor, UriComponentsBuilder ucBuilder) {
		LOG.info("creating new vendor: {}", vendor.getId());
		Vendor createdVendor;
		
		try {
			if (vendorService.exist(vendor.getId())){
			    LOG.info("a vendor with name " + vendor.getId() + " already exists");
			    return new ResponseEntity<Vendor>(HttpStatus.CONFLICT);
			}
			createdVendor = vendorService.create(vendor);
		} catch (ServiceException e) {
			LOG.error("a vendor with name " + vendor.getId() + " create failed", e);
			return new ResponseEntity<Vendor>(HttpStatus.SERVICE_UNAVAILABLE);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/vendors/{id}").buildAndExpand(createdVendor.getId()).toUri());
        return new ResponseEntity<Vendor>(headers, HttpStatus.CREATED);
	}
}