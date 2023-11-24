package com.islol.hyopgg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HyopggApplication {

	public static void main(String[] args) {
		SpringApplication.run(HyopggApplication.class, args);
	}

}
