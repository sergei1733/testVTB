package com.example.apiTest.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Component
@RestController
public class KafkaProducerService {
    @Autowired
    public KafkaTemplate<String, String> kafkaTemplate;
    @PostMapping("/api/{topic}")
    public void sendOrder(@RequestBody String body, @PathVariable String topic) throws IOException {

       Treatment treatment = new Treatment();

        kafkaTemplate.send(topic,  treatment.result(body));
    }
}
