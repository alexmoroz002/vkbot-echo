package com.example.demo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

/**
 * Конфигурация клиента для доступа к ВК
 */
@Configuration
class VKClientConfig {
    @Bean
    fun vkWebClient(): WebClient {
        val token = System.getenv("VK_TOKEN") ?: throw RuntimeException("Missing token")
        return WebClient.builder()
            .baseUrl("https://api.vk.com/method")
            .defaultHeader("Authorization", "Bearer $token")
            .build()
    }
}