package paf.lecture.paf_24l.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(
            new Info()
                .title("PAF Lecture 24")
                .description("Lecture project for PAF Lecture 24")
                .version("0.0.1")
        );
    }
}
