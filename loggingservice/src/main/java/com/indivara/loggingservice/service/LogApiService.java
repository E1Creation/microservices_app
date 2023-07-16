package com.indivara.loggingservice.service;

import com.indivara.loggingservice.dto.request.CreateLogApiRequest;

public interface LogApiService {

    boolean createLogApi(CreateLogApiRequest request);
}
