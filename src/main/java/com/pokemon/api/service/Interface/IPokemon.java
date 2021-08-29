package com.pokemon.api.service.Interface;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.pokemon.api.dto.PokemonBasicDto;
import com.pokemon.api.dto.PokemonPlusInfoDto;
import com.pokemon.api.model.pokemons.InfoPokemons;

@Component
public interface IPokemon {

	InfoPokemons getPokemonsInfo(int limit, int offset);
	ResponseEntity<List<PokemonBasicDto>> getAllPokemons(int limit, int offset);
	PokemonPlusInfoDto getPokemonByName(String name);
}
