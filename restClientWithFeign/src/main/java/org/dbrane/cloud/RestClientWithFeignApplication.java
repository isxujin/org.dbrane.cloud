package org.dbrane.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAutoConfiguration
@RestController
public class RestClientWithFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestClientWithFeignApplication.class, args);
	}
}
