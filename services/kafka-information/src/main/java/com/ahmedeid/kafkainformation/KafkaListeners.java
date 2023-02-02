package com.ahmedeid.kafkainformation;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.ahmedeid.kafkainformation.constants.AppConstantVariables;

@Component
public class KafkaListeners {

    @KafkaListener(topics = AppConstantVariables.TOPIC_NAME,
            groupId = AppConstantVariables.GROUP_ID)
    void listener(String data) {
        System.out.println("Listener received: " + data);
    }
}
