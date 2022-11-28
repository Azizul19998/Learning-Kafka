package com.example.learningkafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    @Value("${my_application.topic_value}")
    String topic;


    @PostMapping("/produce")
    public void createMessage(@RequestParam("msg") String msg) {
        this.kafkaTemplate.send(topic,msg);
    }

    // we will listen to this topic msg via @KafkaListener
}
