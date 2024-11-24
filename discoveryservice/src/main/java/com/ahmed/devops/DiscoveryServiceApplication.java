package com.ahmed.devops;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServiceApplication {
	final Logger logger = LoggerFactory.getLogger(DiscoveryServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServiceApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		logger.info("Registry service started.");
	}
}
