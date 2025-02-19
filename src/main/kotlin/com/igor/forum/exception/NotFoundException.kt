package com.igor.forum.exception

class NotFoundException(
    message: String? = "Resource not found",
) : RuntimeException(message)
