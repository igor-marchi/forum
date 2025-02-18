package com.igor.forum.service

import com.igor.forum.model.User
import org.springframework.stereotype.Service

@Service
class UserService(
    private val users: List<User> =
        listOf(
            User(1, "Igor", ""),
            User(2, "João", ""),
            User(3, "Maria", ""),
        ),
) {
    fun detail(id: Long): User = users.first { it.id == id }
}
