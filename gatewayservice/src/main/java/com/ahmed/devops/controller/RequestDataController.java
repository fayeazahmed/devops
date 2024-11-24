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

    @GetMapping()
    public ResponseEntity<List<RequestData>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping()
    public ResponseEntity<RequestData> save(@RequestBody RequestData data) {
        return ResponseEntity.ok(service.save(data));
    }
}
