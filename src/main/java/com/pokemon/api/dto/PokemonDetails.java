package com.pokemon.api.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class PokemonDetails {

	private String description;
	private List<String> moves = new ArrayList<>();
}
