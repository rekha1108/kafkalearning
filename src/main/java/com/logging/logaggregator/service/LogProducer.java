package com.logging.logaggregator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LogProducer {
    private static final Logger logger = LoggerFactory.getLogger(LogProducer.class);
    private final KafkaTemplate<String, String> kafkaTemplate;

    public LogProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendLog(String message) {
        logger.info("Sending log: " + message);
        kafkaTemplate.send("logs-topic", message);
    }
}

