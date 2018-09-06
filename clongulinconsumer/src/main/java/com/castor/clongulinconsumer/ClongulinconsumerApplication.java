package com.castor.clongulinconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ClongulinconsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClongulinconsumerApplication.class, args);
	}
}
