package com.pokemon.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pokemon.api.service.Interface.IPokemon;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api/")
@AllArgsConstructor
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class PokemonController {

	@Autowired
	private final IPokemon IPok;
	
	
	@GetMapping(path = "pokemons")
	public ResponseEntity<?> allPokemons(@RequestParam int limit, int offset) throws Exception {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(IPok.getAllPokemons(limit, offset));
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Has an error "+ e.getMessage());
		}
	}
	
	@GetMapping(path = "pokemon/{name}")
	public ResponseEntity<?> pokemonInfo(@PathVariable String name) throws Exception{
		try {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(IPok.getPokemonByName(name));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Has an error "+ e.getMessage());
		}
	}
	
	
	
}
