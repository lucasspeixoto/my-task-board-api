package com.lspeixotodev.my_task_board_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("My Task Board API")
                        .version("v1")
                        .description("Documentation about My Task Board API")
                        .termsOfService("https://github.com/lucasspeixoto/my-task-board-api")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://github.com/lucasspeixoto/my-task-board-api")
                        )
                );
    }
}
