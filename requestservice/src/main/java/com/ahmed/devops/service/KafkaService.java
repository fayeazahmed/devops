package com.ahmed.devops.service;

import com.ahmed.devops.exception.InternalKafkaException;
import org.apache.kafka.common.errors.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private final String topic = "requestdata";
    private final Logger logger = LoggerFactory.getLogger(KafkaService.class);

    public void produce(String message) {
        logger.info("Producing message: " + message);

        try {
            kafkaTemplate.send(topic, message);
        } catch (KafkaException | TimeoutException ex) {
            logger.error("Error while producing message: " + ex.getMessage());
            throw new InternalKafkaException();
        }
    }

    public boolean produceAndRespond(String message) {
        logger.info("Producing message: " + message);

        try {
            kafkaTemplate.send(topic, message);
            return true;
        } catch (KafkaException | TimeoutException ex) {
            logger.error("Error while producing message: " + ex.getMessage());
            logger.error("Exiting operation");
            return false;
        }
    }

}
