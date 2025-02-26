package com.API.GED.Kafka.Services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DocumentConsumer {

    @KafkaListener(topics = "document-events", groupId = "ged-group")
    public void consume(String message) {
        System.out.println("📥 Message reçu depuis Kafka : " + message);
    }
}
