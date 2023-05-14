package com.example.demo.event.sourcing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class DemoEventSourcingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoEventSourcingApplication.class, args);
	}

}
