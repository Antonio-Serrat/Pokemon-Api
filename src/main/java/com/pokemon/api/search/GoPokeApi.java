package com.pokemon.api.search;

import java.net.URI;

import org.springframework.web.client.RestTemplate;

import com.pokemon.api.model.InfoPokemons;
import com.pokemon.api.model.Pokemon;
import com.pokemon.api.search.Interface.IGoPokeApi;

public class GoPokeApi implements IGoPokeApi{

	private final RestTemplate restTemplate = new RestTemplate();
	private final URI baseUrl = URI.create("https://pokeapi.co/api/v2/pokemon");

	public InfoPokemons getPokemonsInfo(int limit, int offset) {	
		return restTemplate.getForObject(baseUrl+"?limit="+limit+"$offset="+offset, InfoPokemons.class);
	}

	@Override
	public Pokemon getPokemon(URI uri) {
		return restTemplate.getForObject(uri, Pokemon.class);
	}
	
	
	
}
