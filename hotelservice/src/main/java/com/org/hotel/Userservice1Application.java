package com.org.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Userservice1Application {

	public static void main(String[] args) {
		SpringApplication.run(Userservice1Application.class, args);
	}

}
