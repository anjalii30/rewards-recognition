package com.rewardsandrecognition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CreateAwardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreateAwardApplication.class, args);
	}

}
