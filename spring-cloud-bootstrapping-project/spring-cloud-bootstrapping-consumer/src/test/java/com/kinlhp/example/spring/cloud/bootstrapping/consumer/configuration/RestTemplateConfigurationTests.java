package com.kinlhp.example.spring.cloud.bootstrapping.consumer.configuration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.web.client.RestTemplateBuilder;

@ExtendWith(value = { MockitoExtension.class })
class RestTemplateConfigurationTests {
    @Mock
    private RestTemplateBuilder restTemplateBuilder;

    @InjectMocks
    private RestTemplateConfiguration restTemplateConfiguration;

    @DisplayName(value = "RestTemplate bean creation.")
    @Test
    final void shouldCreateRestTemplateBean() {
        restTemplateConfiguration.restTemplate(restTemplateBuilder);

        Mockito.verify(restTemplateBuilder).build();
    }

}
