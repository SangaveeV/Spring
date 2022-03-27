package com.sangavee.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.sangavee")
@EntityScan(basePackages = "com.sangavee")
public class CoffeeProjectSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeProjectSpringBootApplication.class, args);
	}

}
