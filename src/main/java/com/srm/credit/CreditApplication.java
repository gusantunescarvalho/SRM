package com.srm.credit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class CreditApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditApplication.class);
	}

}
