package com.pokemon.api.service.Impl;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokemon.api.dto.PokemonBasicDto;
import com.pokemon.api.dto.PokemonPlusInfoDto;
import com.pokemon.api.model.pokemons.InfoPokemons;
import com.pokemon.api.model.pokemons.PokemonsUris;
import com.pokemon.api.search.Interface.IGoPokeApi;
import com.pokemon.api.service.Interface.IPokemon;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImplPokemon implements IPokemon {
	private final IGoPokeApi IGo;
	private final ObjectMapper mapper = new ObjectMapper();	
	private final URI baseUrl = URI.create("https://pokeapi.co/api/v2/");

	
	@Override
	public InfoPokemons getPokemonsInfo(int limit, int offset) {
		return IGo.getPokemonsInfo(limit, offset);
	}

	
	@Override
	public List<PokemonBasicDto> getAllPokemons(int limit, int offset) {
		InfoPokemons info = IGo.getPokemonsInfo(limit, offset);
		List<PokemonBasicDto> pokemones = new ArrayList<>();
		List<PokemonsUris> infos = info.getResults();
		
		for (PokemonsUris pokemonsUris : infos) {
			PokemonBasicDto pokemonBasicDto = IGo.getPokemon(URI.create(pokemonsUris.getUrl()));
			pokemonBasicDto.setName(pokemonsUris.getName());
			pokemones.add(pokemonBasicDto);			
		};	
		return pokemones;
	}


	@Override
	public PokemonPlusInfoDto getPokemonByName(String name) {
		URI uri = URI.create(baseUrl + "pokemon/" + name);
		IGo.getPokemon(uri);
		return null;
	}
	
}
