package com.igor.forum.service

import com.igor.forum.dto.TopicForm
import com.igor.forum.dto.TopicView
import com.igor.forum.mapper.TopicFormMapper
import com.igor.forum.mapper.TopicViewMapper
import com.igor.forum.model.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(
    private var topics: List<Topic> = listOf(),
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper,
) {
    fun list(): List<TopicView> =
        topics
            .stream()
            .map { topic -> topicViewMapper.map(topic) }
            .toList()

    fun detail(id: Long): TopicView {
        val topic = topics.find { it.id == id }
        if (topic == null) {
            throw IllegalArgumentException("Topic not found")
        }
        return topicViewMapper.map(topic)
    }

    fun create(topicForm: TopicForm) {
        val newId = topics.size.toLong() + 1
        val topic = topicFormMapper.map(topicForm.setId(newId))
        topics = topics.plus(topic)
    }
}
