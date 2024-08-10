package com.metaphorce.bitacora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@SpringBootApplication
public class BitacoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(BitacoraApplication.class, args);
	}

	// bean para el restTemplate
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();

		// Configuración de autenticación básica
		String username = "admin";
		String password = "admin123";
		String auth = username + ":" + password;
		byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.ISO_8859_1));
		String authHeader = "Basic " + new String(encodedAuth);

		restTemplate.getInterceptors().add((request, body, execution) -> {
			request.getHeaders().add(HttpHeaders.AUTHORIZATION, authHeader);
			return execution.execute(request, body);
		});

		return restTemplate;
	}
}
