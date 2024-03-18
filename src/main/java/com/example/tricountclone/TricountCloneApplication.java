package com.example.tricountclone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TricountCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(TricountCloneApplication.class, args);
	}

}
