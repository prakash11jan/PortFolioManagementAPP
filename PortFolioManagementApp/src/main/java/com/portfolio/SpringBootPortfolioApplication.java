package com.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages="com.portfolio")
public class SpringBootPortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPortfolioApplication.class, args);
	}
}
