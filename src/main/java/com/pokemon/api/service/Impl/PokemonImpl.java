package com.pokemon.api.service.Impl;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokemon.api.model.InfoPokemons;
import com.pokemon.api.service.Interface.PokemonI;

@Service
public class PokemonImpl implements PokemonI {
	
	private final RestTemplate restTemplate = new RestTemplate();
	private final URI baseUrl = URI.create("https://pokeapi.co/api/v2/pokemon");
	private final ObjectMapper mapper = new ObjectMapper();	
	
	
	@Override
	public InfoPokemons getPokemonsInfo(int limit, int offset) {
		
		
		return restTemplate.getForObject(baseUrl+"?limit="+limit+"$offset="+offset, InfoPokemons.class);
	}


//	@Override
//	public List<Pokemon> getAllPokemons(InfoPokemons info) {
//		return info.getResults().stream()
//				.map(p -> {
//					Pokemon pokemone = 
//				});
//	}
	
	
}
