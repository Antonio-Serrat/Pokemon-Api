package com.pokemon.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class PokeApiApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PokeApiApplication.class, args);
	}

}
