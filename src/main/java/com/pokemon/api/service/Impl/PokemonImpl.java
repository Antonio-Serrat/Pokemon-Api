package com.pokemon.api.service.Impl;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokemon.api.model.InfoPokemons;
import com.pokemon.api.model.Pokemon;
import com.pokemon.api.model.PokemonsUris;
import com.pokemon.api.search.Interface.IGoPokeApi;
import com.pokemon.api.service.Interface.PokemonI;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PokemonImpl implements PokemonI {
	private final IGoPokeApi IGo;
	private final ObjectMapper mapper = new ObjectMapper();	
	
	
	@Override
	public InfoPokemons getPokemonsInfo(int limit, int offset) {
		return IGo.getPokemonsInfo(limit, offset);
	}

	
	@Override
	public List<Pokemon> getAllPokemons(int limit, int offset) {
		InfoPokemons info = IGo.getPokemonsInfo(limit, offset);
		List<Pokemon> pokemones = new ArrayList<>();
		List<PokemonsUris> infos = info.getResults();
		
		for (PokemonsUris pokemonsUris : infos) {
			Pokemon pokemon = IGo.getPokemon(URI.create(pokemonsUris.getUrl()));
			pokemon.setName(pokemonsUris.getName());
			pokemones.add(pokemon);			
		};	
		return pokemones;
	}
	
}
