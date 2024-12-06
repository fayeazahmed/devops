package com.ahmed.devops.controller;

import com.ahmed.devops.model.RequestData;
import com.ahmed.devops.service.RequestDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("request_data")
public class RequestDataController {
    private final RequestDataService requestDataService;
    private final Logger logger = LoggerFactory.getLogger(RequestDataController.class);

    public RequestDataController(RequestDataService requestDataService) {
        this.requestDataService = requestDataService;
    }

    /**
     * Handle request for all saved request data.
     * @return List of request data
     */
    @GetMapping()
    public ResponseEntity<List<RequestData>> getAll() {
        logger.info("Handling data request");

        return ResponseEntity.ok(requestDataService.getAll());
    }
}
