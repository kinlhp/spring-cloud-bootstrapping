package com.kinlhp.example.spring.cloud.bootstrapping.consumer.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class GreetingService {
    private final RandomGreetingConsumer randomGreetingConsumer;

    public GreetingService(final RandomGreetingConsumer randomGreetingConsumer) {
        this.randomGreetingConsumer = randomGreetingConsumer;
    }

    public String greet(final String name) {
        final var randomGreeting = randomGreetingConsumer.requestRandomGretting();
        return randomGreeting + (StringUtils.hasText(name) ? " " + name + "!" : "!");
    }

}
