package com.app.corona.tracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.app.corona.tracker.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

	@SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "CoVID19 Tracker Api",
                "Tracking Api to Show CoVID19 Cases Daily",
                "",
                "Terms of service",
                "corona@mail.com",
                "",
                "");
        return apiInfo;
    }

}
