package com.pokemon.api.service.Interface;

import java.util.List;

import com.pokemon.api.model.InfoPokemons;
import com.pokemon.api.model.Pokemon;

public interface PokemonI {

	InfoPokemons getPokemonsInfo(int limit, int offset);
	List<Pokemon> getAllPokemons(int limit, int offset);
}
