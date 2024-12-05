package com.ahmed.devops.client;

import com.ahmed.devops.model.RequestData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "handlerservice")
public interface APIClient {
    @GetMapping("/request_data")
    ResponseEntity<List<RequestData>> getAll();
}
