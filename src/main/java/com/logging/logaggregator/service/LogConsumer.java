package com.logging.logaggregator.service;

import com.logging.logaggregator.entity.LogEntry;
import com.logging.logaggregator.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class LogConsumer {
    @Autowired
    private LogRepository logRepository;

    @KafkaListener(topics = "logs-topic", groupId = "log-consumers")
    public void consumeLog(String logMessage) {
        logRepository.save(new LogEntry(logMessage));
    }
}