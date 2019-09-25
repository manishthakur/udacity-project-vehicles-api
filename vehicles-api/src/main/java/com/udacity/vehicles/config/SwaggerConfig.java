package com.udacity.vehicles.config;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

@Configuration
@EnableSwagger2
@ApiResponses(value = {
        @ApiResponse(code = 400, message = "This is a bad request."),
        @ApiResponse(code = 401, message = "This is an unauthorized request."),
        @ApiResponse(code = 501, message = "The server id down.")
})
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Vehicle Pricing Service", "Udacity Project", "1.0", "n/a",
                new Contact("manish", "n/a", "manishthakur.in@gmail.com"),
                "n/a", "n/a", Collections.emptySet()
        );
    }
}
