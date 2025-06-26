package com.dancesys.dancesys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DancesysApplication {

	public static void main(String[] args) {
		SpringApplication.run(DancesysApplication.class, args);
	}

}
