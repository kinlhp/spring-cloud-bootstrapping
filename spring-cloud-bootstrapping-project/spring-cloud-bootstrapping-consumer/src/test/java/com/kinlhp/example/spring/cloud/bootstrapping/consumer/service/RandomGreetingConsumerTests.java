package com.kinlhp.example.spring.cloud.bootstrapping.consumer.service;

import java.net.URI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

@ExtendWith(value = { MockitoExtension.class })
class RandomGreetingConsumerTests {
    private static final String GREETING = "Hello";
    private static final URI RANDOM_GREETING_PROVIDER_URI = URI.create("http://provider");

    @InjectMocks
    private RandomGreetingConsumer randomGreetingConsumer;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private ServiceDiscovery serviceDiscovery;

    @DisplayName(value = "Get a random greeting.")
    @Test
    final void shouldGetARandomGreeting() {
        Mockito.when(serviceDiscovery.getInstance(Mockito.any()))
                .thenReturn(RANDOM_GREETING_PROVIDER_URI);
        Mockito.when(restTemplate.getForObject(Mockito.any(), Mockito.any()))
                .thenReturn(GREETING);

        final var randomGreeting = randomGreetingConsumer.requestRandomGretting();

        Assertions.assertAll("greeting",
                () -> Assertions.assertNotNull(randomGreeting, () -> "Should not get null."),
                () -> Assertions.assertEquals("Hello", randomGreeting, () -> "Should get Hello."));
    }

}
