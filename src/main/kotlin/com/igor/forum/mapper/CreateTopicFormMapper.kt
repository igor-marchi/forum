package com.igor.forum.mapper

import com.igor.forum.controller.dto.CreateTopicForm
import com.igor.forum.model.Topic
import com.igor.forum.service.CourseService
import com.igor.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class CreateTopicFormMapper(
    private val courseService: CourseService,
    private val userService: UserService,
) : Mapper<CreateTopicForm, Topic> {
    override fun map(t: CreateTopicForm): Topic =
        Topic(
            id = t.id,
            title = t.title,
            message = t.message,
            course = courseService.detail(t.courseId),
            author = userService.detail(t.authorId),
        )
}
