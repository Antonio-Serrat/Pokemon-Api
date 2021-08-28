package com.pokemon.api.search.Interface;

import java.net.URI;

import org.springframework.stereotype.Component;

import com.pokemon.api.model.InfoPokemons;
import com.pokemon.api.model.Pokemon;

@Component
public interface IGoPokeApi {

	InfoPokemons getPokemonsInfo(int limit, int offset);
	Pokemon getPokemon(URI uri);
	
	
}
