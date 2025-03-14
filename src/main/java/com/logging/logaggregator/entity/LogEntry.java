package com.logging.logaggregator.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Timestamp;

@Entity
public class LogEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logMessage;
    private Timestamp logTime;

    public LogEntry(String logMessage) {
        this.logMessage = logMessage;
        this.logTime = new Timestamp(System.currentTimeMillis());
    }
}
