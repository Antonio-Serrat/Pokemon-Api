package com.pokemon.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jayway.jsonpath.JsonPath;
import com.pokemon.api.service.Interface.IPokemon;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/")
@AllArgsConstructor
public class PokemonController {

	private final IPokemon IPok;
	
	
	@GetMapping
	public ResponseEntity<?> allPokemons(@RequestParam int limit, int offset){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(JsonPath.parse(IPok.getAllPokemons(limit, offset)));
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Has an error "+ e.getMessage());
		}
	}
	
	@GetMapping("pokemon/{name}")
	public ResponseEntity<?> pokemonInfo(@PathVariable String name){
		try {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(JsonPath.parse(IPok.getPokemonByName(name)));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Has an error "+ e.getMessage());
		}
	}
	
	
	
}
