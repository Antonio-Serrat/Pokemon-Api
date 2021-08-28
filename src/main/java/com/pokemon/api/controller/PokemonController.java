	package com.pokemon.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pokemon.api.service.Interface.PokemonI;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api/")
@AllArgsConstructor
public class PokemonController {

	private final PokemonI IPok;
	
	
	@GetMapping("/pokemons")
	public ResponseEntity<?> allPokemons(@RequestParam int limit, int offset){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(IPok.getPokemonsInfo(limit, offset));
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Has an error"+ e.getMessage());
		}
	}
	
	
	
}
