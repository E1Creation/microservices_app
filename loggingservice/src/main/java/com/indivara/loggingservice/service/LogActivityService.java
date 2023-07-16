package com.indivara.loggingservice.service;

import com.indivara.loggingservice.dto.request.CreateLogActivityRequest;

public interface LogActivityService {
    boolean createLogActivity(CreateLogActivityRequest request);
}
