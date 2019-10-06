package com.tcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.tcs.bean.CustomerResponse;

@SpringBootApplication
@ComponentScan
public class SpringBootJpaApplication {
	
	@Bean
	public CustomerResponse getCustomerResponse() {
		return new CustomerResponse();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);
	}

}
