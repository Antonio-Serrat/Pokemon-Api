package com.pokemon.api.service.Interface;

import java.util.List;

import com.pokemon.api.dto.PokemonBasicDto;
import com.pokemon.api.dto.PokemonPlusInfoDto;
import com.pokemon.api.model.pokemons.InfoPokemons;

public interface IPokemon {

	InfoPokemons getPokemonsInfo(int limit, int offset);
	List<PokemonBasicDto> getAllPokemons(int limit, int offset);
	PokemonPlusInfoDto getPokemonByName(String name);
}
