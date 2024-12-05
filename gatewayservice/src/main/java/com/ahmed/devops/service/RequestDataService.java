package com.ahmed.devops.service;

import com.ahmed.devops.model.RequestData;
import com.ahmed.devops.repository.RequestDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestDataService {
    private final RequestDataRepository repository;

    public RequestDataService(RequestDataRepository repository) {
        this.repository = repository;
    }

    /**
     * Get all request data from database.
     * @return List of request data
     */
    public List<RequestData> getAll() {
        return repository.findAll();
    }

    /**
     * Save a new request data into database.
     * @param data Request data
     * @return Saved request data
     */
    public RequestData save(RequestData data) {
        return repository.save(data);
    }
}
