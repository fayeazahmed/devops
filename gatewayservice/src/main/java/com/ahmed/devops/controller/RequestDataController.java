package com.ahmed.devops.controller;

import com.ahmed.devops.service.RequestDataService;
import com.ahmed.devops.model.RequestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data/")
public class RequestDataController {
    @Autowired
    private RequestDataService service;

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
