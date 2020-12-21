package com.anz.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AnzUserAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnzUserAccountServiceApplication.class, args);
	}

}
