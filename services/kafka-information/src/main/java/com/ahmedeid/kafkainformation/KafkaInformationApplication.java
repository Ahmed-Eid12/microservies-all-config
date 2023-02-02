package com.ahmedeid.kafkainformation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import com.ahmedeid.kafkainformation.constants.AppConstantVariables;

import static com.ahmedeid.kafkainformation.constants.AppConstantVariables.*;

@SpringBootApplication
public class KafkaInformationApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaInformationApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
        return args -> {
            for(int i=1; i<=10; i++) {
                kafkaTemplate.send(TOPIC_NAME, "Hi -> ahmed eid = " + i + "");
            }
        };
    }

}
