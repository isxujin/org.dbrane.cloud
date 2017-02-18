package org.dbrane.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableAutoConfiguration
public class FinanceMarketOpenDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanceMarketOpenDataApplication.class, args);
	}
}
