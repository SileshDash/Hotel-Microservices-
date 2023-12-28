package com.org.serviceresigistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceResigistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceResigistryApplication.class, args);
	}

}
