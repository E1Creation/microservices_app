package com.indivara.loggingservice.service.impl;

import com.indivara.loggingservice.converter.LogApiConverter;
import com.indivara.loggingservice.dto.request.CreateLogApiRequest;
import com.indivara.loggingservice.entity.LogApi;
import com.indivara.loggingservice.repo.LogApiRepository;
import com.indivara.loggingservice.service.LogApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LogApiServiceImpl implements LogApiService {
    private final LogApiRepository logApiRepository;
    private final LogApiConverter logApiConverter;
    @Override
    public boolean createLogApi(CreateLogApiRequest request) {
       log.info("After kafka consumer");
        LogApi logApi = logApiConverter.toModelLogApi(request);
        log.info("hasil log api : {}", logApi);
        logApiRepository.save(logApi);
        return true;
    }
}
