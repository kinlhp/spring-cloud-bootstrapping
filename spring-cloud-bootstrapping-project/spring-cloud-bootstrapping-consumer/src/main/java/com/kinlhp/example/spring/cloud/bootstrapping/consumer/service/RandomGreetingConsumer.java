package com.kinlhp.example.spring.cloud.bootstrapping.consumer.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RandomGreetingConsumer {
    private final RestTemplate restTemplate;
    private final ServiceDiscovery serviceDiscovery;

    @Value(value = "${provider.random-greeting.resource-uri:/greetings}")
    private String randomGreetingResourceUri;

    @Value(value = "${provider.random-greeting.service-id:provider}")
    private String randomGreetingServiceId;

    public RandomGreetingConsumer(final RestTemplate restTemplate, final ServiceDiscovery serviceDiscovery) {
        this.restTemplate = restTemplate;
        this.serviceDiscovery = serviceDiscovery;
    }

    public String requestRandomGretting() {
        final var providerUri = serviceDiscovery.getInstance(randomGreetingServiceId);
        return restTemplate.getForObject(URI.create(providerUri.toString() + randomGreetingResourceUri), String.class);
    }

}
