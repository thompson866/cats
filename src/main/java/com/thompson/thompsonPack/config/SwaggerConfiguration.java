package com.thompson.thompsonPack.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI openApi() {//<dependency>    <groupId>org.springdoc</groupId>   <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>  <version>2.6.0</version></dependency>
        return new OpenAPI()
                .servers(List.of(new Server()
                        .url("http://localhost:8080"))).
                info(new Info().title("Our cats API"));

    }

}
