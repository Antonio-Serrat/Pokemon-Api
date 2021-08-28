package com.pokemon.api.model.pokemons;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class InfoPokemons {
	
	private int count;
	private String next;
	private String previous;
	private List<PokemonsUris> results;
	
}
