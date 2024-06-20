package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class PersonnalOpggProjectApplication {

	public static void main(String[] args) {
		System.setProperty("log4j2.formatMsgNoLookups", "true");
		
		SpringApplication.run(PersonnalOpggProjectApplication.class, args);
	}
}
