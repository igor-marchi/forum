package com.igor.forum.model

import java.time.LocalDateTime

data class Response(
    val id: Long? = null,
    val message: String,
    val topic: Topic,
    val author: User,
    val isSolution: Boolean,
    val dateCreated: LocalDateTime = LocalDateTime.now(),
)
