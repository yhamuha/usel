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
import com.usel.app.model.User;
import com.usel.app.service.UserService;
import com.usel.app.service.exception.ServiceException;


@RestController
@RequestMapping("/users")
public class UserController {
	
	private final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAll() {
		LOG.info("getting all users");
		
		List<User> users = null;
		try {
			users = userService.findAll();
			if (users == null || users.isEmpty()){
	            LOG.info("no users found");
	            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
	        }
		} catch (ServiceException e) {
			LOG.error("getting all surveys failed", e);
			return new ResponseEntity<List<User>>(HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		LOG.info("creating new user: {}", user.getEmail());
		User createdUser;
		
		try {
			if (userService.exist(user.getEmail())){
			    LOG.info("a user with name " + user.getEmail() + " already exists");
			    return new ResponseEntity<User>(HttpStatus.CONFLICT);
			}
			createdUser = userService.create(user);
		} catch (ServiceException e) {
			LOG.error("a user with name " + user.getEmail() + " create failed", e);
			return new ResponseEntity<User>(HttpStatus.SERVICE_UNAVAILABLE);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/users/{id}").buildAndExpand(createdUser.getId()).toUri());
        return new ResponseEntity<User>(headers, HttpStatus.CREATED);
	}
}