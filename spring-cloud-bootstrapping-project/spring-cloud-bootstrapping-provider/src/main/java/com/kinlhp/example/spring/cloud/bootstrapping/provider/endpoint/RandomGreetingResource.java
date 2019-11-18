package com.kinlhp.example.spring.cloud.bootstrapping.provider.endpoint;

import com.kinlhp.example.spring.cloud.bootstrapping.provider.service.RandomGreetingService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = { "/greetings" })
@RestController
public class RandomGreetingResource {
    private final RandomGreetingService service;

    public RandomGreetingResource(final RandomGreetingService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<String> getRandomGreeting() {
        final var randomGreeting = service.getRandomGreeting();
        return ResponseEntity.ok(randomGreeting);
    }

}
