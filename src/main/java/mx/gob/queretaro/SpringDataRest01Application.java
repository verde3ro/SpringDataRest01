package mx.gob.queretaro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot Data Rest",
				description = "Spring Boot Data Rest Application",
				version = "1.0",
				contact = @Contact(
						name = "Raúl alejandro Verde Martínez",
						url = "https://github.com/verde3ro",
						email = "verde3ro@gmail.com"
						),
				license = @License(
						name = "MIT Licence",
						url = "https://github.com/verde3ro")
				)
		)
@SpringBootApplication
public class SpringDataRest01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRest01Application.class, args);
	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();

		config.setAllowCredentials(true);
		config.addAllowedOrigin("*"); // * Todos
		config.addAllowedHeader("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("DELETE");

		source.registerCorsConfiguration("/api/**", config); // A que rutas aplicar

		return new CorsFilter(source);
	}

}
