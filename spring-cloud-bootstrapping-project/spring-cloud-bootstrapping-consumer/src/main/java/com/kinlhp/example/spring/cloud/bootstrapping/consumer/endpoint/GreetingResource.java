package com.kinlhp.example.spring.cloud.bootstrapping.consumer.endpoint;

import com.kinlhp.example.spring.cloud.bootstrapping.consumer.service.GreetingService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = { "/greetings" })
@RestController
public class GreetingResource {
    private final GreetingService greetingService;

    public GreetingResource(final GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public ResponseEntity<String> greet(@RequestParam(name = "name", required = false) final String name) {
        final var greet = greetingService.greet(name);
        return ResponseEntity.ok(greet);
    }

}
