package com.nic.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class NicApplication {

	public static void main(String[] args) {
		SpringApplication.run(NicApplication.class, args);
	}

}
