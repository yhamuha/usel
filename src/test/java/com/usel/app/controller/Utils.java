package com.usel.app.controller;


import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {
	public static String asJsonString(final Object obj) {
	    
		System.out.println("CHECK POINT 2 - asJsonString");
		
		try {
	        return new ObjectMapper().writeValueAsString(obj);
	        
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
