package com.usel.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UselBoot {
	
	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(UselBoot.class, args);
	}
}