//package com.pokemon.api.config;
//
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class WebSecConf {
//
//	
//		 @Bean
//		 public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		        http.requiresChannel().anyRequest().requiresSecure();
//		        return http.build();
//		    }
//		 
//	 
//	  protected void configure(HttpSecurity http) throws Exception {
//	    http.requiresChannel()
//	      .requestMatchers(r -> r.getHeader("X-Forwarded-Proto") != null)
//	      .requiresSecure();
//	    
//	    
//	    http.authorizeRequests().antMatchers("/api/**").permitAll().anyRequest()
//	    .authenticated();
//	  }
//	}
//
