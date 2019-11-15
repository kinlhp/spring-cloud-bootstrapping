package com.kinlhp.example.spring.cloud.bootstrapping.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Application {

	public static final void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
