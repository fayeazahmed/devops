package com.ahmed.devops.service;

import com.ahmed.devops.model.RequestData;
import com.ahmed.devops.repository.RequestDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestDataService {

    @Autowired
    private RequestDataRepository repository;

    public List<RequestData> getAll() {
        return repository.findAll();
    }

    public RequestData save(RequestData data) {
        return repository.save(data);
    }
}
