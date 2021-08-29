package com.pokemon.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class MainApplication {


    @RequestMapping("/")
    @ResponseBody
    String home() {
      return "Principal page, please write --> ' /api/pokemons?limit=5&offset=0 '  or ' /api/pokemon/bulbasaur ' ";
    }
	
	
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

}
