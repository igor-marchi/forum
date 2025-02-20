package com.igor.forum.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail

open class MainException : RuntimeException() {
    open fun toProblemDetail(): ProblemDetail =
        ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR).apply {
            title = "Internal Server Error"
            detail = "An unexpected error occurred"
        }
}
