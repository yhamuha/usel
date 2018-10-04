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
import com.usel.app.model.Purchase;
import com.usel.app.service.PurchaseService;
import com.usel.app.service.exception.ServiceException;


@RestController
@RequestMapping("/purchases")
public class PurchaseController {
	
	private final Logger LOG = LoggerFactory.getLogger(PurchaseController.class);
	
	@Autowired
	PurchaseService purchaseService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Purchase>> getAll() {
		LOG.info("getting all purchases");
		
		List<Purchase> purchases = null;
		try {
			purchases = purchaseService.findAll();
			if (purchases == null || purchases.isEmpty()){
	            LOG.info("no purchases found");
	            return new ResponseEntity<List<Purchase>>(HttpStatus.NO_CONTENT);
	        }
		} catch (ServiceException e) {
			LOG.error("getting all surveys failed", e);
			return new ResponseEntity<List<Purchase>>(HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<List<Purchase>>(purchases, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@PostMapping
	public ResponseEntity<Purchase> create(@RequestBody Purchase purchase, UriComponentsBuilder ucBuilder) {
		LOG.info("creating new purchase: {}", purchase.getEmail());
		Purchase createdPurchase;
		
		try {
			if (purchaseService.exist(purchase.getEmail())){
			    LOG.info("a purchase with name " + purchase.getEmail() + " already exists");
			    return new ResponseEntity<Purchase>(HttpStatus.CONFLICT);
			}
			createdPurchase = purchaseService.create(purchase);
		} catch (ServiceException e) {
			LOG.error("a purchase with name " + purchase.getEmail() + " create failed", e);
			return new ResponseEntity<Purchase>(HttpStatus.SERVICE_UNAVAILABLE);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/purchases/{id}").buildAndExpand(createdPurchase.getId()).toUri());
        return new ResponseEntity<Purchase>(headers, HttpStatus.CREATED);
	}
}