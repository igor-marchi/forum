package com.igor.forum.controller.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class CreateTopicForm(
    @field:NotEmpty @field:Size(min = 2, max = 100)
    val title: String,
    @field:NotEmpty
    val message: String,
    @field:NotNull
    val courseId: Long,
    @field:NotNull
    val authorId: Long,
) {
    var id: Long? = null

    fun setId(id: Long): CreateTopicForm {
        this.id = id
        return this
    }
}
