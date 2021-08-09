package com.luv2codeinjava.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title="Department API",version = "2.0", description = "Specification for Department API" ))
public class SbPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbPracticeApplication.class, args);
	}

}
