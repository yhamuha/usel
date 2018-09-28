package com.usel.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class UselBoot {
	
	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(UselBoot.class, args);
	}
}