package com.eksad.latihanrest.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.service.Tags;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {
	
	@Bean
	public Docket eksadAPI() {
		return new Docket (DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.eksad.latihanrest"))
				.paths(regex("/api.*"))
				.build()
				.apiInfo(metaInfo())
				.tags(
						new Tag("Brand", "Supermarket Brand Management API"),
						new Tag("Product", "Supermarket Product Management API"),
						new Tag("Data Manipulation API", "Supermarket"),
						new Tag("Get Data API", "Supermarket")
						);

	}
	
	private ApiInfo metaInfo() {
		 ApiInfo apiInfo = new ApiInfo("Supermarket",
					"Rest API Collecyion for Supermarket",
					"1.0.0", 
					"http://google.com" , 
					new Contact("Sepmin Sarina", "http://www.sarina.com", "sepminsarinamanurung@gmail.com"), 
					"Sarina 2.0","",
					Collections.emptyList());		 
				 
				 
				
		 return apiInfo;
	}
}
