package com.ahmed.devops.client;

import com.ahmed.devops.model.RequestData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "gatewayservice")
public interface APIClient {
    @PostMapping("/api/data/")
    ResponseEntity<RequestData> save(RequestData data);

    @GetMapping("/api/data/")
    ResponseEntity<List<RequestData>> getAll();
}
