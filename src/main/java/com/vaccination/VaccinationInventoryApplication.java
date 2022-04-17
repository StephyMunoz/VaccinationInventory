package com.vaccination;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VaccinationInventoryApplication implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// service.register("stef_79@gmail.com");

	}

	public static void main(String[] args) {
		SpringApplication.run(VaccinationInventoryApplication.class, args);
	}

}
