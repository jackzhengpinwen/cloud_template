package com.zpw.sprintboot.sprintboottemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SprintbootTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintbootTemplateApplication.class, args);
	}

}
