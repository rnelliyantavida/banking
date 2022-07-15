package com.springBootProject.accountTransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AccountTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountTransactionApplication.class, args);
	}

}
