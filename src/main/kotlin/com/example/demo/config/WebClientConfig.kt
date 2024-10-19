package com.example.demo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfig {
    @Bean
    fun webClient(): WebClient {
        val token = System.getenv("VK_TOKEN") ?: throw RuntimeException("Missing token")
        return WebClient.builder()
            .baseUrl("https://api.vk.com/method")
            .defaultHeader("Authorization", "Bearer $token")
            .build()
    }
}