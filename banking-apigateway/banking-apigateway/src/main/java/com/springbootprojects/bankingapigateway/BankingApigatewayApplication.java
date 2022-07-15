package com.springbootprojects.bankingapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@SpringBootApplication
@EnableEurekaClient
public class BankingApigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingApigatewayApplication.class, args);
	}


}
