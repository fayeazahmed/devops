package com.ahmed.devops.exception;

import com.ahmed.devops.config.Responses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    private final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    @ExceptionHandler(value = { InternalKafkaException.class })
    public ResponseEntity<String> kafkaException(InternalKafkaException ex) {
        logger.error("InternalKafkaException: " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(ex.getMessage());
    }

    @ExceptionHandler(value = { HttpMessageNotReadableException.class })
    public ResponseEntity<String> badRequestException(HttpMessageNotReadableException ex) {
        logger.error("HttpMessageNotReadableException: " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Responses.BAD_REQUEST_RESPONSE);
    }
}
