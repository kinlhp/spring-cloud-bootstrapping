package com.kinlhp.example.spring.cloud.bootstrapping.provider.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class RandomGreetingService {
    private final List<String> greetings = Collections.unmodifiableList(Arrays.asList("Hello", "Hey", "Hi"));

    public String getRandomGreeting() {
        final var randomIndex = new Random().nextInt(greetings.size());
        return greetings.get(randomIndex);
    }

}
