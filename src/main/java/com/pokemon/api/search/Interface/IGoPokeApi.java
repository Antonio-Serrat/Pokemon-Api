package com.pokemon.api.search.Interface;

import java.net.URI;

import org.springframework.stereotype.Component;

import com.pokemon.api.dto.PokemonBasicDto;
import com.pokemon.api.dto.PokemonPlusInfoDto;
import com.pokemon.api.model.pokemons.InfoPokemons;
import com.pokemon.api.model.pokemons.atributes.Descriptions;

@Component
public interface IGoPokeApi {

	InfoPokemons getPokemonsInfo(int limit, int offset);
	PokemonBasicDto getPokemon(URI uri);
	PokemonPlusInfoDto getPokemonInfo(URI uri);
	Descriptions getDescription(URI uri, int id);
	
	
}
