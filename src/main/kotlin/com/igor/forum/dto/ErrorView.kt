package com.igor.forum.dto

import java.time.LocalDateTime

class ErrorView(
    val message: String?,
    val status: Int,
    val error: String,
    val path: String,
    val timestamp: LocalDateTime = LocalDateTime.now(),
)
