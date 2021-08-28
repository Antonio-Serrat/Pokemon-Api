package com.pokemon.api.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Type {

	private String name;
	private String url;
}
