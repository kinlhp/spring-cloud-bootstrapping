package com.kinlhp.example.spring.cloud.bootstrapping.consumer.service;

import java.net.URI;
import java.util.Collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@ExtendWith(value = { MockitoExtension.class })
class ServiceDiscoveryTests {
    private static final String SERVICE_ID = "provider";
    private static final int SERVICE_PORT = 8083;
    private static final URI SERVICE_URI = URI.create(String.format("http://%s:%d", SERVICE_ID, SERVICE_PORT));

    @Mock
    private DefaultServiceInstance serviceInstance;

    @Mock
    private DiscoveryClient discoveryClient;

    @InjectMocks
    private ServiceDiscovery serviceDiscovery;

    @DisplayName(value = "Instance by service id.")
    @Test
    final void shouldGetInstanceByServiceId() {
        Mockito.when(discoveryClient.getInstances(Mockito.anyString()))
                .thenReturn(Collections.singletonList(serviceInstance));
        Mockito.when(serviceInstance.getUri())
                .thenReturn(SERVICE_URI);

        final var uri = serviceDiscovery.getInstance(SERVICE_ID);

        Assertions.assertAll("instances",
                () -> Assertions.assertNotNull(uri, () -> "Should not get null."),
                () -> Assertions.assertEquals(URI.create("http://provider:8083"), uri, () -> "Should get http://provider:8083."));
    }

    @DisplayName(value = "Exception when no instance is found by service id.")
    @Test
    final void shouldThrowIllegalArgumentExceptionWhenNoInstanceIsFoundByServiceId() {
        Mockito.when(discoveryClient.getInstances(Mockito.anyString()))
                .thenReturn(Collections.emptyList());

        final var exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> serviceDiscovery.getInstance(SERVICE_ID), "Should throws IllegalArgumentException.");
        Assertions.assertEquals("No instances registered for 'provider' service were found.", exception.getMessage(), () -> "Should be: No instances registered for 'provider' service were found.");
    }

}
