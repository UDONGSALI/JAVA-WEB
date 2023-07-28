package com.springboot.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {

	@Bean
	OpenAPI openAPI() {
		return new OpenAPI()
				.components(new Components())
				.info(apiInfo());
	}
	
	private Info apiInfo() {
		return new Info()
				.title("JPA TEST API DOCS")
				.version("v1")
				.description("JPA 프로젝트 API TEST 명세서");
	}
}
