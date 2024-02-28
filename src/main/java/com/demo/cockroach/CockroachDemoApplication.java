package com.demo.cockroach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.demo.cockroach")
public class CockroachDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CockroachDemoApplication.class, args);
	}

}

