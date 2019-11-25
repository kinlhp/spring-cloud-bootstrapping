package com.kinlhp.example.spring.cloud.bootstrapping.consumer.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(value = { MockitoExtension.class })
class GreetingServiceTests {
    private static final String GREETING = "Hey";
    private static final String NAME = "Foo";

    @InjectMocks
    private GreetingService greetingService;

    @Mock
    private RandomGreetingConsumer randomGreetingConsumer;

    @DisplayName(value = "Greet with null name.")
    @Test
    final void shouldGreetWithNullName() {
        Mockito.when(randomGreetingConsumer.requestRandomGretting())
                .thenReturn(GREETING);

        final var greeting = greetingService.greet(null);

        Assertions.assertEquals("Hey!", greeting, () -> "Should be: Hey!");
    }

    @DisplayName(value = "Greet with empty name.")
    @Test
    final void shouldGreetWithEmptyName() {
        Mockito.when(randomGreetingConsumer.requestRandomGretting())
                .thenReturn(GREETING);

        final var greeting = greetingService.greet(null);

        Assertions.assertEquals("Hey!", greeting, () -> "Should be: Hey!");
    }

    @DisplayName(value = "Greet with name having only whitespace.")
    @Test
    final void shouldGreetWithNameHavingOnlyWhitespace() {
        Mockito.when(randomGreetingConsumer.requestRandomGretting())
                .thenReturn(GREETING);

        final var greeting = greetingService.greet(" ");

        Assertions.assertEquals("Hey!", greeting, () -> "Should be: Hey!");
    }

    @DisplayName(value = "Greet with specific name.")
    @Test
    final void shouldGreetWithSpecificName() {
        Mockito.when(randomGreetingConsumer.requestRandomGretting())
                .thenReturn(GREETING);

        final var greeting = greetingService.greet(NAME);

        Assertions.assertEquals("Hey Foo!", greeting, () -> "Should be: Hey Foo!");
    }

}
