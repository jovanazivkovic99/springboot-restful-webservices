package com.jovana.springbootrestfulwebservices;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Spring Boot REST API Documentation",
                description = "Spring Boot REST API Documentation",
                version = "v1.0",
                contact = @Contact(
                        name = "Jovana",
                        email = "jovanakipar@gmail.com",
                        url = "https://github.com/jovanazivkovic99"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://github.com/jovanazivkovic99"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Spring Boot User Management Documentation",
                url = "https://github.com/jovanazivkovic99"
        )
)
public class SpringbootRestfulWebservicesApplication {
    
    public static void main (String[] args) {
        SpringApplication.run(SpringbootRestfulWebservicesApplication.class, args);
    }
    
}
