package com.negs.springboot.microservice.scientific.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.negs.springboot.microservice.scientific.calculator" })
public class ScientificCalculatorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScientificCalculatorServiceApplication.class, args);
	}

}
