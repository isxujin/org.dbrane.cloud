package org.dbrane.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class ConfigClientExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientExampleApplication.class, args);
	}
}
