package com.igor.forum.controller

import com.igor.forum.controller.dto.CreateTopicForm
import com.igor.forum.controller.dto.TopicView
import com.igor.forum.controller.dto.UpdateTopicForm
import com.igor.forum.service.TopicService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topics")
class TopicController(
    private val topicService: TopicService,
) {
    @GetMapping
    fun list(): List<TopicView> = topicService.list()

    @GetMapping("/{id}")
    fun detail(
        @PathVariable id: Long,
    ): TopicView = topicService.detail(id)

    @PostMapping
    fun crete(
        @RequestBody @Valid topicDto: CreateTopicForm,
        uriBuilder: UriComponentsBuilder,
    ): ResponseEntity<TopicView> {
        val topic = topicService.create(topicDto)
        val uri = uriBuilder.path("/topics/${topic.id}").build().toUri()
        return ResponseEntity.created(uri).body(topic)
    }

    @PutMapping
    fun update(
        @RequestBody @Valid updateTopicForm: UpdateTopicForm,
    ): ResponseEntity<TopicView> = ResponseEntity.ok(topicService.update(updateTopicForm))

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(
        @PathVariable id: Long,
    ) = topicService.delete(id)
}
