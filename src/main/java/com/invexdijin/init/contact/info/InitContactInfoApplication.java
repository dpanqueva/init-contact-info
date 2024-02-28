package com.invexdijin.init.contact.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class InitContactInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(InitContactInfoApplication.class, args);
	}

}
