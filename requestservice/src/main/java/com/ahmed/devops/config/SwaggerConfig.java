package com.ahmed.devops.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Request Service Documentation")
                        .description("Request Service API documentation.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Fayeaz Ahmed")
                                .email("fayeazahmed418@gmail.com")
                                .url("https://fayeazahmed.github.io/"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html"))
                );
    }
}
