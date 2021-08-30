package com.pokemon.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pokemon.api.service.Interface.IPokemon;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api")
@AllArgsConstructor
public class PokemonController {

	@Autowired
	private final IPokemon IPok;
	
	
	@GetMapping(path = "/pokemons")
    @ApiOperation("Can list all the Pokemons you want ")
	public ResponseEntity<?> allPokemons(@RequestParam int limit, int offset) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(IPok.getAllPokemons(limit, offset));
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Has an error "+ e.getMessage());
		}
	}
	
	@GetMapping(path = "/pokemon/{name}")
    @ApiOperation("Search your favorite Pokemon by name")
	public ResponseEntity<?> pokemonInfo(@PathVariable String name) {
		try {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(IPok.getPokemonByName(name));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Has an error "+ e.getMessage());
		}
	}
	
	
	
}
