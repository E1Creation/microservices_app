package com.indivara.loggingservice.service.impl;

import com.indivara.loggingservice.converter.LogActivityConverter;
import com.indivara.loggingservice.dto.request.CreateLogActivityRequest;
import com.indivara.loggingservice.entity.LogActivity;
import com.indivara.loggingservice.repo.LogActivityRepository;
import com.indivara.loggingservice.service.LogActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogActivityServiceImpl implements LogActivityService {

   private final LogActivityConverter logActivityConverter;
   private final LogActivityRepository logActivityRepository;
    @Override
    public boolean createLogActivity(CreateLogActivityRequest request) {
        final LogActivity logActivity =  logActivityConverter.toModelLogActivity(request);
        logActivityRepository.save(logActivity);
        return true;
    }
}
