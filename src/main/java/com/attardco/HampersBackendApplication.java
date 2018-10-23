package com.attardco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class HampersBackendApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(HampersBackendApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication sa = new SpringApplication(HampersBackendApplication.class);
		sa.run(args);
		// SpringApplication.run(HampersBackendApplication.class, args);
	}

}
