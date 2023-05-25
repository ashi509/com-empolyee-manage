package com.empolyee.manage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .paths(regex("/employee/.*"))
                .build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Employee management system",
                "Employee monitoring system",
                "1.0",
                "Terms and service",
                new Contact("Ashish", "URL", "ashish@gmail.com"),
                "License of api",
                "localhost:9090/employee-api/swagger-ui.html",
                Collections.emptyList()
        );
    }

}