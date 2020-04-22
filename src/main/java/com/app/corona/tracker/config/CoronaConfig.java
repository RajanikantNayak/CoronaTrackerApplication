package com.app.corona.tracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CoronaConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
