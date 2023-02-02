package com.ahmedeid.kafkainformation.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahmedeid.kafkainformation.constants.AppConstantVariables;
import com.ahmedeid.kafkainformation.requests.MessageRequest;

@RestController
@RequestMapping("api/v1/messages")
public class MessagesController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public MessagesController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void publishMessages(@RequestBody MessageRequest messageRequest) {
        kafkaTemplate.send(AppConstantVariables.TOPIC_NAME, messageRequest.message());
    }
}
