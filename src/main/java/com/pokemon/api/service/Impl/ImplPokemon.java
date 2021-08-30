package com.pokemon.api.service.Impl;

import java.net.URI;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pokemon.api.dto.PokemonBasicDto;
import com.pokemon.api.dto.PokemonPlusInfoDto;
import com.pokemon.api.model.pagin.PaginatedPokemons;
import com.pokemon.api.model.pokemons.InfoPokemons;
import com.pokemon.api.model.pokemons.PokemonsUris;
import com.pokemon.api.model.pokemons.atributes.Characteristic;
import com.pokemon.api.model.pokemons.atributes.Description;
import com.pokemon.api.search.Interface.IGoPokeApi;
import com.pokemon.api.service.Interface.IPokemon;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImplPokemon implements IPokemon {
	private final IGoPokeApi IGo;
	private final URI baseUrl = URI.create("https://pokeapi.co/api/v2/");

	
	@Override
	public InfoPokemons getPokemonsInfo(int limit, int offset) {
		return IGo.getPokemonsInfo(limit, offset);
	}

	
	@Override
	public PaginatedPokemons getAllPokemons(int limit, int offset) {
		InfoPokemons info = IGo.getPokemonsInfo(limit, offset);
		PaginatedPokemons pokemons = new PaginatedPokemons();
		pokemons.setNext(info.getNext());
		pokemons.setPrevious(info.getPrevious());
		List<PokemonsUris> infos = info.getResults();
		
		for(PokemonsUris pokemonsUris : infos) {
			PokemonBasicDto pokemonBasicDto = IGo.getPokemon(URI.create(pokemonsUris.getUrl()));
			pokemonBasicDto.setName(pokemonsUris.getName());
			pokemons.getPokemons().add(pokemonBasicDto);
			
		};	
		return pokemons;
	}


	@Override
	public PokemonPlusInfoDto getPokemonByName(String name) {
		URI uriPokemon = URI.create(baseUrl + "pokemon/" + name);		
		PokemonPlusInfoDto pokemon = IGo.getPokemonInfo(uriPokemon);
		
		int id = pokemon.getId();
		URI uriDes = URI.create(baseUrl + "characteristic/" + id);
		Characteristic characteristic = IGo.getDescription(uriDes);
		
		for (Description des : characteristic.getDescriptions()) {
			String languaje = des.getLanguage().getName();
		 
			if(languaje.matches("es")) {
				pokemon.setCharacteristic(des);
			}
		}
		return pokemon;
	}
	
}
