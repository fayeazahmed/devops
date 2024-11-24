package com.ahmed.devops.exception;

import com.ahmed.devops.config.Responses;

public class InternalKafkaException extends RuntimeException {

    public InternalKafkaException() {
        this(Responses.SAVE_REQUEST_FAILED_RESPONSE);
    }

    public InternalKafkaException(String message) {
        super(message);
    }

}
