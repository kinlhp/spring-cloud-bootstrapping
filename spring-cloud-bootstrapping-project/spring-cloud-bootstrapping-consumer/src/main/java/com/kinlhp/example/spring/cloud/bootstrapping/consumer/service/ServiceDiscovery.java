package com.kinlhp.example.spring.cloud.bootstrapping.consumer.service;

import java.net.URI;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

@Component
public class ServiceDiscovery {
    private final DiscoveryClient discoveryClient;

    public ServiceDiscovery(final DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    public URI getInstance(final String serviceId) {
        return discoveryClient.getInstances(serviceId)
                .stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("No instances registered for '%s' service were found.", serviceId)))
                .getUri();
    }

}
