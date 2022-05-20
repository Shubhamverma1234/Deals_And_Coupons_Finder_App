package com.cg;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class DealsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DealsServiceApplication.class, args);
	}

}
