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
    @Autowired
    private APIClient apiClient;
    @Autowired
    private KafkaService kafkaService;
    private final Logger logger = LoggerFactory.getLogger(RequestDataService.class);

    /**
     * Produce a message to kafka for saving request data.
     * @param data Request data string
     */
    public void save(String data) {
        kafkaService.produce(data);
    }

    /**
     * Make api call to get all saved request data.
     * @return List of request data
     */
    public List<RequestData> getAll() {
        try {
            ResponseEntity<List<RequestData>> response = apiClient.getAll();
            return response.getBody();
        } catch (FeignException e) {
            logger.error("Error while fetching request data: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * Produce target number of message to kafka for saving request data.
     * @param numberOfData Requested number of message to produce
     * @return Number of successfully produced message
     */
    public int generate(int numberOfData) {
        for(int i = 0; i < numberOfData; i++) {
            if(!kafkaService.produceAndRespond("Generated request data " + (i + 1))) {
                return ++i;
            }
        }

        return numberOfData;
    }
}
