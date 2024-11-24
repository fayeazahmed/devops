package com.ahmed.devops;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableFeignClients
public class RequestServiceApplication {
	final Logger logger = LoggerFactory.getLogger(RequestServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RequestServiceApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		logger.info("Request service started.");
	}
}
