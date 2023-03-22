package com.anr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.config.EnableIntegration;

@SpringBootApplication
@EnableIntegration
public class SpringIntegrationSampleAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationSampleAppApplication.class, args);
	}

}
