package com.logging.logaggregator.controller;

import com.logging.logaggregator.service.LogProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {
    private final LogProducer logProducer;

    public LogController(LogProducer logProducer) {
        this.logProducer = logProducer;
    }

    @GetMapping("/log")
    public String logMessage(@RequestParam String message) {
        logProducer.sendLog(message);
        return "Log sent!";
    }
}
