package com.pokemon.api.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConf {

		@Bean
		public Docket apiDocket() {
			return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.basePackage("com.pokemon.api.controller"))
					.paths(PathSelectors.any())
					.build()
					.apiInfo(getApiInfo())
					;
		}
		
		private ApiInfo getApiInfo() {
			return new ApiInfo(
					"Pokemon Api-Rest ",
					"You can search your favorite Pokemon and all of them",
					"4.0.0",
					"Terms of service",	
					new Contact("Antonio Serrat", "https://www.linkedin.com/in/antonio-serrat/", "4antoniogabriel20@gmail.com"),
					"LICENSE",
					"LICENSE URL",
					Collections.emptyList()
					);
		}
	
}
