package com.ahmed.devops.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    private final RequestDataService requestDataService;
    private final FileWriterService fileWriterService;
    private final static String consumerGroupId = "devops-group";
    private final static String topic = "requestdata";
    private final Logger logger = LoggerFactory.getLogger(KafkaService.class);

    public KafkaService(RequestDataService requestDataService, FileWriterService fileWriterService) {
        this.requestDataService = requestDataService;
        this.fileWriterService = fileWriterService;
    }

    @KafkaListener(topics = topic, groupId = consumerGroupId)
    public void consume(String message) {
        logger.info("Received message: {}", message);
        requestDataService.save(message);
        fileWriterService.writeToFile(message);
    }
}
