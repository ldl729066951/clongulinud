package com.castor.clongulineureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ClongulineurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClongulineurekaApplication.class, args);
	}
}
