package com.metaphorce.bitacora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BitacoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(BitacoraApplication.class, args);
	}

	// bean para el restTemplate
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
