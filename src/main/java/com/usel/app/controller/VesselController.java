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
import com.usel.app.model.Vessel;
import com.usel.app.service.VesselService;
import com.usel.app.service.exception.ServiceException;


@RestController
@RequestMapping("/vessels")
public class VesselController {
	
	private final Logger LOG = LoggerFactory.getLogger(VesselController.class);
	
	@Autowired
	VesselService vesselService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Vessel>> getAll() {
		LOG.info("getting all vessels");
		
		List<Vessel> vessels = null;
		try {
			vessels = vesselService.findAll();
			if (vessels == null || vessels.isEmpty()){
	            LOG.info("no vessels found");
	            return new ResponseEntity<List<Vessel>>(HttpStatus.NO_CONTENT);
	        }
		} catch (ServiceException e) {
			LOG.error("getting all surveys failed", e);
			return new ResponseEntity<List<Vessel>>(HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<List<Vessel>>(vessels, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@PostMapping
	public ResponseEntity<Vessel> create(@RequestBody Vessel vessel, UriComponentsBuilder ucBuilder) {
		LOG.info("creating new vessel: {}", vessel.getId());
		Vessel createdVessel;
		
		try {
			if (vesselService.exist(vessel.getId())){
			    LOG.info("a vessel with name " + vessel.getId() + " already exists");
			    return new ResponseEntity<Vessel>(HttpStatus.CONFLICT);
			}
			createdVessel = vesselService.create(vessel);
		} catch (ServiceException e) {
			LOG.error("a vessel with name " + vessel.getId() + " create failed", e);
			return new ResponseEntity<Vessel>(HttpStatus.SERVICE_UNAVAILABLE);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/vessels/{id}").buildAndExpand(createdVessel.getId()).toUri());
        return new ResponseEntity<Vessel>(headers, HttpStatus.CREATED);
	}
}