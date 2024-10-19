package com.example.demo.dto

/**
 * Описывает сообщение, отправленное боту пользователем
 **/

data class Message(
    val date : Int,
    val id : Int,
    val text : String,
    val peerId : Int
)