package com.dio.james.heroesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HeroesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeroesApiApplication.class, args);
		System.out.println("Management Heroes with WebFlux");
	}

}
