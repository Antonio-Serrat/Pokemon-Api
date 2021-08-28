package com.pokemon.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Pokemon {

	private String 	weight;
	private List<Photo> sprites;
	private List<Type> types;
	private List<Ability> abilities;
}
