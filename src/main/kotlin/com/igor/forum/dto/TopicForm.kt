package com.igor.forum.dto

data class TopicForm(
    val title: String,
    val message: String,
    val courseId: Long,
    val authorId: Long,
) {
    var id: Long? = null

    fun setId(id: Long): TopicForm {
        this.id = id
        return this
    }
}
