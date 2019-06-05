package com.stackroute.muzixrecommendersystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class MuzixRecommenderSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuzixRecommenderSystemApplication.class, args);
	}

}

