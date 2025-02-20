package com.igor.forum.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail

class NotFoundException(
    private val errorDetail: String = "The requested resource was not found",
) : MainException() {
    override fun toProblemDetail(): ProblemDetail =
        ProblemDetail.forStatus(HttpStatus.NOT_FOUND).apply {
            title = "Not Found"
            detail = errorDetail
        }
}
