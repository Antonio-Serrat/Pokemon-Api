package com.pokemon.api.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Photo {

	private String front_default;

}
