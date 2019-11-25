package com.kinlhp.example.spring.cloud.bootstrapping.consumer.endpoint;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Set;

import com.kinlhp.example.spring.cloud.bootstrapping.consumer.service.ServiceDiscovery;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestTemplate;

@AutoConfigureMockMvc
@SpringBootTest
class GreetingResourceTests {
    private static final MediaType APPLICATION_JSON_UTF8 = new MediaType("application", "json", StandardCharsets.UTF_8);
    private static final Set<String> GREETINGS = Set.of("Hello", "Hey", "Hi");
    private static final String NAME = "Bar";
    private static final URI RANDOM_GREETING_PROVIDER_URI = URI.create("http://provider");
    private static final String RESOURCE = "/greetings";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RestTemplate restTemplate;

    @MockBean
    private ServiceDiscovery serviceDiscovery;

    @DisplayName(value = "Request greetings with no name.")
    @Test
    final void shouldReturnGreetingsWithNoName() throws Exception {
        Mockito.when(serviceDiscovery.getInstance(Mockito.any()))
                .thenReturn(RANDOM_GREETING_PROVIDER_URI);
        Mockito.when(restTemplate.getForObject(Mockito.any(), Mockito.any()))
                .thenReturn(GREETINGS.stream().findAny().get());

        mockMvc.perform(MockMvcRequestBuilders.get(RESOURCE).accept(APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.is(Matchers.oneOf("Hello!", "Hey!", "Hi!"))));
    }

    @DisplayName(value = "Request greetings with specific name.")
    @Test
    final void shouldReturnGreetingsWithSpecificName() throws Exception {
        Mockito.when(serviceDiscovery.getInstance(Mockito.any()))
                .thenReturn(RANDOM_GREETING_PROVIDER_URI);
        Mockito.when(restTemplate.getForObject(Mockito.any(), Mockito.any()))
                .thenReturn(GREETINGS.stream().findAny().get());

        mockMvc.perform(MockMvcRequestBuilders.get(RESOURCE).param("name", NAME).accept(APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.is(Matchers.oneOf("Hello Bar!", "Hey Bar!", "Hi Bar!"))));
    }

}
