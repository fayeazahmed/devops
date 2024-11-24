package com.ahmed.devops.controller;

import com.ahmed.devops.config.Responses;
import com.ahmed.devops.exception.InternalKafkaException;
import com.ahmed.devops.model.RequestData;
import com.ahmed.devops.service.RequestDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("request_data")
public class RequestDataController {
    @Autowired
    private RequestDataService requestDataService;
    private final Logger logger = LoggerFactory.getLogger(RequestDataController.class);

    @PostMapping()
    public ResponseEntity<String> save(@RequestBody String data) {
        logger.info("Received request data: " + data);

        requestDataService.save(data);

        return ResponseEntity.ok(Responses.SAVE_REQUEST_RESPONSE);
    }

    @GetMapping()
    public ResponseEntity<List<RequestData>> getAll() {
        logger.info("Requesting data");

        return ResponseEntity.ok(requestDataService.getAll());
    }

}
