package com.API.GED.Kafka.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Service
public class DocumentProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "document-events";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public DocumentProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvent(String operationType, Integer documentId) {
        try {
            // Construire le message dans un HashMap
            Map<String, Object> event = new HashMap<>();
            event.put("type", operationType);
            event.put("documentId", documentId);
            event.put("timestamp", Instant.now().toString());

            //Convertir le message en JSON
            String jsonMessage = objectMapper.writeValueAsString(event);

            kafkaTemplate.send(TOPIC, jsonMessage);
            System.out.println("📤 Événement envoyé : " + jsonMessage);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
