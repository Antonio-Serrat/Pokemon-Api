package com.pokemon.api.search.Impl;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pokemon.api.dto.PokemonBasicDto;
import com.pokemon.api.dto.PokemonPlusInfoDto;
import com.pokemon.api.model.pokemons.InfoPokemons;
import com.pokemon.api.model.pokemons.atributes.Characteristic;
import com.pokemon.api.search.Interface.IGoPokeApi;

@Service
public class ImplGoPokeApi implements IGoPokeApi{

	private final RestTemplate restTemplate = new RestTemplate();
	private final URI baseUrl = URI.create("https://pokeapi.co/api/v2/");

	public InfoPokemons getPokemonsInfo(int limit, int offset) {	
		return restTemplate.getForObject(baseUrl + "/pokemon?limit=" + limit + "$offset=" + offset, InfoPokemons.class);
	}

	@Override
	public PokemonBasicDto getPokemon(URI uri) {
		return restTemplate.getForObject(uri, PokemonBasicDto.class);
	}

	@Override
	public Characteristic getDescription(URI uri) {
		return restTemplate.getForObject(uri, Characteristic.class);
	}

	@Override
	public PokemonPlusInfoDto getPokemonInfo(URI uri) {
		return restTemplate.getForObject(uri, PokemonPlusInfoDto.class);
	}
	
	
	
}
