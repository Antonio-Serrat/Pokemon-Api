package com.pokemon.api.search.Interface;

import java.net.URI;

import org.springframework.stereotype.Component;

import com.pokemon.api.dto.CharacteristicsUrlDTO;
import com.pokemon.api.dto.PokemonBasicDto;
import com.pokemon.api.dto.PokemonDescriptionsDto;
import com.pokemon.api.dto.PokemonPlusInfoDto;
import com.pokemon.api.model.pokemons.InfoPokemons;
import com.pokemon.api.model.pokemons.atributes.Characteristic;

@Component
public interface IGoPokeApi {

	InfoPokemons getPokemonsInfo(int limit, int offset);
	PokemonBasicDto getPokemon(URI uri);
	PokemonPlusInfoDto getPokemonInfo(String name);
	Characteristic getDescription(URI uri);
	PokemonDescriptionsDto getAllStats(String name);
	CharacteristicsUrlDTO getUrlCharacts(URI uri);
	
	
}
