package com.pokemon.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.pokemon.api.model.pokemons.atributes.*;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonPlusInfoDto {

	private int id;
	private String name;
	private String 	weight;
	private Sprites sprites;
	private List<Types> types;
	private List<Abilities> abilities;
	private Moves moves;
	private Descriptions descriptions;

}
