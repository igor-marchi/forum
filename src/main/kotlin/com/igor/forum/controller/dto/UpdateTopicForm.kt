package com.igor.forum.controller.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class UpdateTopicForm(
    @field:NotNull
    val id: Long,
    @field:NotEmpty @field:Size(min = 2, max = 100)
    val title: String,
    @field:NotEmpty
    val message: String,
)
