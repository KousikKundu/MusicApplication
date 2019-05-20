package com.stackroute.muzixmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MuzixManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuzixManagerApplication.class, args);
	}

}

