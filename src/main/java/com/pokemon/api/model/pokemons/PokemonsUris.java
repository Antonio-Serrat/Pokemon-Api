package com.pokemon.api.model.pokemons;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;


@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PokemonsUris {

	private String name;
	private String url;
}
