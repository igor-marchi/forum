package com.igor.forum.exception

import com.igor.forum.dto.FieldErrorView
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(exception: NotFoundException): ProblemDetail = exception.toProblemDetail()

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleValidation(exception: MethodArgumentNotValidException): ProblemDetail =
        ProblemDetail.forStatus(HttpStatus.BAD_REQUEST).apply {
            title = "Your request parameters didn't validate"
            this.setProperty("invalid-params", buildFieldErrorsView(exception))
        }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleServerError(exception: Exception): ProblemDetail =
        ProblemDetail
            .forStatus(HttpStatus.INTERNAL_SERVER_ERROR)
            .apply {
                title = "Internal Server Error"
                detail = "An unexpected error occurred"
            }

    private fun buildFieldErrorsView(exception: MethodArgumentNotValidException): List<FieldErrorView> =
        exception.fieldErrors
            .stream()
            .map { fieldError ->
                FieldErrorView(
                    field = fieldError.field,
                    message = fieldError.defaultMessage ?: "Invalid value",
                )
            }.toList()
}
