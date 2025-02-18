package com.igor.forum.mapper

import com.igor.forum.dto.TopicForm
import com.igor.forum.model.Topic
import com.igor.forum.service.CourseService
import com.igor.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val userService: UserService,
) : Mapper<TopicForm, Topic> {
    override fun map(t: TopicForm): Topic =
        Topic(
            id = t.id,
            title = t.title,
            message = t.message,
            course = courseService.detail(t.courseId),
            author = userService.detail(t.authorId),
        )
}
