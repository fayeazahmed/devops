package com.ahmed.devops.repository;

import com.ahmed.devops.model.RequestData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestDataRepository extends JpaRepository<RequestData, Long> {
}
