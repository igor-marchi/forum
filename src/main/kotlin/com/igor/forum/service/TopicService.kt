package com.igor.forum.service

import com.igor.forum.dto.CreateTopicForm
import com.igor.forum.dto.TopicView
import com.igor.forum.dto.UpdateTopicForm
import com.igor.forum.exception.NotFoundException
import com.igor.forum.mapper.CreateTopicFormMapper
import com.igor.forum.mapper.TopicViewMapper
import com.igor.forum.model.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(
    private var topics: List<Topic> = listOf(),
    private val topicViewMapper: TopicViewMapper,
    private val createTopicFormMapper: CreateTopicFormMapper,
) {
    fun list(): List<TopicView> =
        topics
            .stream()
            .map { topic -> topicViewMapper.map(topic) }
            .toList()

    fun detail(id: Long): TopicView {
        val topic = topics.find { it.id == id }
        if (topic == null) throw NotFoundException()
        return topicViewMapper.map(topic)
    }

    fun create(createTopicForm: CreateTopicForm): TopicView {
        val newId = topics.size.toLong() + 1
        val topic = createTopicFormMapper.map(createTopicForm.setId(newId))
        topics = topics.plus(topic)
        return topicViewMapper.map(topic)
    }

    fun update(updateTopicForm: UpdateTopicForm): TopicView {
        val oldTopic = topics.find { it.id == updateTopicForm.id }
        if (oldTopic == null) throw NotFoundException()
        val newTopic =
            oldTopic.copy(
                title = updateTopicForm.title,
                message = updateTopicForm.message,
            )
        topics =
            topics
                .minus(oldTopic)
                .plus(newTopic)
        return topicViewMapper.map(newTopic)
    }

    fun delete(id: Long) {
        val topic = topics.find { it.id == id }
        if (topic == null) throw NotFoundException()
        topics = topics.minus(topic)
    }
}
