package com.ahmed.devops.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    @Autowired
    RequestDataService requestDataService;
    @Autowired
    FileWriterService fileWriterService;
    private final String consumerGroupId = "devops-group";
    private final String topic = "requestdata";
    private final Logger logger = LoggerFactory.getLogger(KafkaService.class);

    @KafkaListener(topics = topic, groupId = consumerGroupId)
    public void consume(String message) {
        logger.info("Received message: " + message);
        requestDataService.save(message);
        fileWriterService.writeToFile(message);
    }
}
