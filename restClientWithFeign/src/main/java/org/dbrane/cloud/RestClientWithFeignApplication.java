package org.dbrane.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
public class RestClientWithFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestClientWithFeignApplication.class, args);
	}
	
}
