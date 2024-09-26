package br.com.tendtudo.tendtudo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
public OpenAPI customOpenApi(){
    return new OpenAPI().info(new Info().title("TendTudo Roupas API").version("Beta1.0")
        .license(new License().name("Licença do sistema").url("www.tendtudoroupas.com.br")));
    }

}