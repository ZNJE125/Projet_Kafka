package com.API.GED.Kafka.Services;

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
    private final ObjectMapper objectMapper = new ObjectMapper(); // ✅ Jackson pour convertir en JSON

    public DocumentProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvent(String operationType, Integer documentId) {
        try {
            // ✅ Construire le message JSON
            Map<String, Object> event = new HashMap<>();
            event.put("type", operationType);
            event.put("documentId", documentId);
            event.put("timestamp", Instant.now().toString());

            String jsonMessage = objectMapper.writeValueAsString(event);

            // ✅ Envoyer à Kafka
            kafkaTemplate.send(TOPIC, jsonMessage);
            System.out.println("📤 Événement envoyé : " + jsonMessage);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
