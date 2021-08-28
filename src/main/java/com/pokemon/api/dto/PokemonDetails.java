package com.pokemon.api.dto;

import java.util.List;

import com.pokemon.api.model.Move;
import com.pokemon.api.model.Pokemon;

import lombok.Data;

@Data
public class PokemonDetails {
	
	private Pokemon pokemon;
	private String description;
	private List<Move> moves;
}
