package com.ahmed.devops.controller;

import com.ahmed.devops.config.Responses;
import com.ahmed.devops.model.RequestData;
import com.ahmed.devops.service.RequestDataService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("request_data")
public class RequestDataController {
    private final RequestDataService requestDataService;
    private final Logger logger = LoggerFactory.getLogger(RequestDataController.class);

    public RequestDataController(RequestDataService requestDataService) {
        this.requestDataService = requestDataService;
    }

    @PostMapping()
    @Tag(name = "Save data", description = "Send a message to kafka to save request data")
    public ResponseEntity<String> save(@RequestBody String data) {
        logger.info("Received request data: {}", data);

        requestDataService.save(data);

        return ResponseEntity.ok(Responses.SAVE_REQUEST_RESPONSE);
    }

    @GetMapping()
    @Tag(name = "Get data", description = "Get all saved request data")
    public ResponseEntity<List<RequestData>> getAll() {
        logger.info("Requesting data");

        return ResponseEntity.ok(requestDataService.getAll());
    }

    @PostMapping("/generate")
    @Tag(name = "Generate data", description = "Generate specific number of request data")
    public ResponseEntity<String> generate(@RequestBody int numberOfData) {
        logger.info("Received data generation request: {}", numberOfData);

        int generatedDataCount = requestDataService.generate(numberOfData);

        return ResponseEntity.ok(Responses.GENERATION_REQUEST_RESPONSE + generatedDataCount);
    }

}
