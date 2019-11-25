package com.kinlhp.example.spring.cloud.bootstrapping.provider.service;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(value = { MockitoExtension.class })
class RandomGreetingServiceTests {
    @InjectMocks
    private RandomGreetingService service;

    @DisplayName(value = "Random greeting.")
    @Test
    final void shouldReturnRandomGreeting() {
        final var greeting = service.getRandomGreeting();

        Assertions.assertAll("greetings",
                () -> Assertions.assertNotNull(greeting, () -> "Should not return null."),
                () -> MatcherAssert.assertThat(greeting, Matchers.is(Matchers.oneOf("Hello", "Hey", "Hi"))));
    }

}
