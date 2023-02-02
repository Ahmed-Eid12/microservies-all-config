package com.ahmedeid.kafkainformation.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static com.ahmedeid.kafkainformation.constants.AppConstantVariables.*;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic kafkaNewTopic() {
        return TopicBuilder.name(TOPIC_NAME)
                .build();
    }
}
