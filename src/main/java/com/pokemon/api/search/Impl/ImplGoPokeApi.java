package com.pokemon.api.search.Impl;

import java.net.URI;

import org.springframework.cache.annotation.Cacheable;
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
	private final URI baseUrl = URI.create("https://pokeapi.co/api/v2");
	private final URI descUrl = URI.create("https://pokeapi.co/api/v2/characteristic");
	private final URI pokeUrl = URI.create("https://pokeapi.co/api/v2/pokemon");


	@Override
	@Cacheable("PokemonsInfo")
	public InfoPokemons getPokemonsInfo(int limit, int offset) {	
		return restTemplate.getForObject(baseUrl + "/pokemon?limit=" + limit + "&offset=" + offset, InfoPokemons.class);
	}

	@Override
	@Cacheable("PokemonsDetails")
	public PokemonBasicDto getPokemon(URI uri) {
		return restTemplate.getForObject(uri, PokemonBasicDto.class);
	}

	@Override
	@Cacheable("PokemonDescription")
	public Characteristic getDescription(int id) {
		return restTemplate.getForObject(descUrl +"/"+ id, Characteristic.class);
	}

	@Override
	@Cacheable("Pokemon")
	public PokemonPlusInfoDto getPokemonInfo(String name ) {
		return restTemplate.getForObject(pokeUrl +"/"+name, PokemonPlusInfoDto.class);
	}
	
	
	
}
