package com.ahmed.devops.service;

import com.ahmed.devops.client.APIClient;
import com.ahmed.devops.model.RequestData;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RequestDataService {
    private final APIClient apiClient;
    private final Logger logger = LoggerFactory.getLogger(RequestDataService.class);

    public RequestDataService(APIClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Send api call to save request data.
     * @param data Request data string
     */
    public void save(String data) {
        RequestData requestData = new RequestData(0, data);
        try {
            ResponseEntity<RequestData> response = apiClient.save(requestData);
            requestData = response.getBody();
            if(requestData == null) return;
        } catch (FeignException e) {
            logger.error("Error while saving request data: {}", e.getMessage());
            return;
        }
        logger.info("Saved data id: {}", requestData.getId());
    }

    /**
     * Send api call to fetch saved request data.
     * @return List of request data
     */
    public List<RequestData> getAll() {
        try {
            ResponseEntity<List<RequestData>> response = apiClient.getAll();
            return response.getBody();
        } catch (FeignException e) {
            logger.error("Error while fetching request data: {}", e.getMessage());
            return new ArrayList<>();
        }
    }
}
