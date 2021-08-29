package com.pokemon.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecConf extends WebSecurityConfigurerAdapter{

	
	 @Bean
	 public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http.requiresChannel().anyRequest().requiresSecure();
	        return http.build();
	    }
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http.requiresChannel()
	      .requestMatchers(r -> r.getHeader("X-Forwarded-Proto") != null)
	      .requiresSecure();
	    
	    
	    http.authorizeRequests().antMatchers("/api/**").permitAll().anyRequest()
	    .authenticated();
	  }
	}

