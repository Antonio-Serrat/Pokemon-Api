package com.pokemon.api.model.pagin;

import java.util.ArrayList;
import java.util.List;

import com.pokemon.api.dto.PokemonBasicDto;

import lombok.Data;


@Data
public class PaginatedPokemons {

	private String previous;
	private String next;
	private List<PokemonBasicDto> pokemons = new ArrayList<>();
}
