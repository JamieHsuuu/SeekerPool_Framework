package com.jamie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SeekerPoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeekerPoolApplication.class, args);
	}

}
