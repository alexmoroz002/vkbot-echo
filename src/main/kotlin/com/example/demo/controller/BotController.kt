package com.example.demo.controller

import com.example.demo.dto.MessageEvent
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.BodyInserters.fromMultipartData
import org.springframework.web.reactive.function.client.WebClient

/**
 * Контроллер, выполняющий получение и обработку событий от Callback API
 *
 * @param client бин WebClient, выполняющий запросы к API ВКонтакте от имени сообщества
 */
@RestController
@RequestMapping("/callback")
class BotController(val client: WebClient) {
    /**
     * Обрабатывает сообщения, отправляемые боту и отвечает пользователям
     */
    @PostMapping(path = ["/message"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun message(@RequestBody event : MessageEvent) : String {
        client.post().uri("/messages.send?user_id=448725350&v=5.199&random_id=0")
            .contentType(MediaType.MULTIPART_FORM_DATA)
            .body(fromMultipartData("message", "Вы написали: ${event.wrapper.message.text}"))
            .retrieve().toEntity(String::class.java)
            .block()
        return "ok"
    }
}