package com.kinlhp.example.spring.cloud.bootstrapping.provider.service;

import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomGreetingServiceTests {
    private static RandomGreetingService service;
    private static Set<String> greetings;

    @BeforeAll
    static void setup() {
        service = new RandomGreetingService();
        greetings = Set.of("Hello", "Hey", "Hi");
    }

    @DisplayName(value = "Random greeting test.")
    @Test
    void shouldReturnRandomGreeting() {
        final var greeting = service.getRandomGreeting();
        Assertions.assertAll("greetings",
                () -> Assertions.assertNotNull(greeting, () -> "Should not be null."),
                () -> Assertions.assertTrue(greetings.contains(greeting), () -> "Should return Hello, Hey or Hi."));
    }

}
