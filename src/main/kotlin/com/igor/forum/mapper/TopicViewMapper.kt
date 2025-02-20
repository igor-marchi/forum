package com.igor.forum.mapper

import com.igor.forum.controller.dto.TopicView
import com.igor.forum.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper : Mapper<Topic, TopicView> {
    override fun map(t: Topic): TopicView =
        TopicView(
            id = t.id,
            title = t.title,
            message = t.message,
            status = t.status,
            dateCreated = t.dateCreated,
        )
}
