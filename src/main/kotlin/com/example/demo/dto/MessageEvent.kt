package com.example.demo.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class MessageEvent(
    @JsonProperty("object") val wrapper : MessageWrapper
)

data class MessageWrapper(
    val message : Message
)