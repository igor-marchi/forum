package com.igor.forum.service

import com.igor.forum.model.Course
import org.springframework.stereotype.Service

@Service
class CourseService(
    private val courses: List<Course> =
        listOf(
            Course(1, "Kotlin", "Programming"),
            Course(2, "Java", "Programming"),
            Course(3, "Spring Boot", "Framework"),
        ),
) {
    fun detail(id: Long): Course = courses.first { it.id == id }
}
