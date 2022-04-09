package io.swagger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-07T09:02:41.194Z[GMT]")
@Configuration
public class SwaggerDocumentationConfig {

    @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.OAS_30)
                .select()
                    .apis(RequestHandlerSelectors.basePackage("io.swagger.api"))
                    .build()
                .directModelSubstitute(org.threeten.bp.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(org.threeten.bp.OffsetDateTime.class, java.util.Date.class)
                .apiInfo(apiInfo());
    }

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("City Transport API")
            .description("The City Transport API supports the simple city transport management system for officials. It is developed under Cybernetica AS' Internship Programme 2022.  The API includes the following capabilities and operations:  __Manage Buses:__  * List all busses * Insert a new bus * Update bus serve line. * Delete bus with given ID.  __Manage Bus Lines:__  * List all bus stops * Create a bus stop * List all bus lines * Create a bus line  This API offers the following resource collections:    * Bus - represents the physical bus with the license number and serving bus line.   * Bus line - describes a collection of bus stops with the given name.    * Bus stop - describes a named location with coordinates where buses are intended to stop. ")
            .license("")
            .licenseUrl("http://unlicense.org")
            .termsOfServiceUrl("https://cyber.ee/careers/internships/")
            .version("1.0.1")
            .contact(new Contact("","", "internship@cyber.ee"))
            .build();
    }

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
            .info(new Info()
                .title("City Transport API")
                .description("The City Transport API supports the simple city transport management system for officials. It is developed under Cybernetica AS' Internship Programme 2022.  The API includes the following capabilities and operations:  __Manage Buses:__  * List all busses * Insert a new bus * Update bus serve line. * Delete bus with given ID.  __Manage Bus Lines:__  * List all bus stops * Create a bus stop * List all bus lines * Create a bus line  This API offers the following resource collections:    * Bus - represents the physical bus with the license number and serving bus line.   * Bus line - describes a collection of bus stops with the given name.    * Bus stop - describes a named location with coordinates where buses are intended to stop. ")
                .termsOfService("https://cyber.ee/careers/internships/")
                .version("1.0.1")
                .license(new License()
                    .name("")
                    .url("http://unlicense.org"))
                .contact(new io.swagger.v3.oas.models.info.Contact()
                    .email("internship@cyber.ee")));
    }

}
