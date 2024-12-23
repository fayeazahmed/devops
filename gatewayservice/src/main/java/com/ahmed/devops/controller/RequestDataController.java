package com.ahmed.devops.controller;

import com.ahmed.devops.model.RequestData;
import com.ahmed.devops.service.RequestDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data/")
public class RequestDataController {
    private final RequestDataService service;

    public RequestDataController(RequestDataService service) {
        this.service = service;
    }

    /**
     * Get all saved request data.
     * @return List of request data
     */
    @GetMapping()
    public ResponseEntity<List<RequestData>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    /**
     * Save a request data.
     * @param data Request data
     * @return Saved request data
     */
    @PostMapping()
    public ResponseEntity<RequestData> save(@RequestBody RequestData data) {
        return ResponseEntity.ok(service.save(data));
    }
}
