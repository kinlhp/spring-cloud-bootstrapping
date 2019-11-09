package com.kinlhp.example.spring.cloud.bootstrapping.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableConfigServer
@EnableEurekaClient
@SpringBootApplication
public class Application {

    public static final void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
