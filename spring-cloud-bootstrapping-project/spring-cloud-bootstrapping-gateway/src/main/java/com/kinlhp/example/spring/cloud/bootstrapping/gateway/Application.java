package com.kinlhp.example.spring.cloud.bootstrapping.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class Application {

	public static final void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
