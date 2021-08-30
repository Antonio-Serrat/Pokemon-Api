package com.pokemon.api.service.Interface;

import org.springframework.stereotype.Component;

import com.pokemon.api.dto.PokemonPlusInfoDto;
import com.pokemon.api.model.pagin.PaginatedPokemons;
import com.pokemon.api.model.pokemons.InfoPokemons;

@Component
public interface IPokemon {

	InfoPokemons getPokemonsInfo(int limit, int offset);
	PaginatedPokemons getAllPokemons(int limit, int offset);
	PokemonPlusInfoDto getPokemonByName(String name);
}
