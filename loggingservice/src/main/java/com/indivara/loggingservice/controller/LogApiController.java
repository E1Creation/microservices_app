package com.indivara.loggingservice.controller;


import com.indivara.loggingservice.dto.request.CreateLogActivityRequest;
import com.indivara.loggingservice.dto.request.CreateLogApiRequest;
import com.indivara.loggingservice.service.LogActivityService;
import com.indivara.loggingservice.service.LogApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/logging")
@RequiredArgsConstructor
public class LogApiController {
    private final LogApiService logApiService;
    private final LogActivityService logActivityService;

    @PostMapping("/api")
    public boolean createLogApi(@RequestBody CreateLogApiRequest request) {
        logApiService.createLogApi(request);
        return true;
    }

    @PostMapping("/activity")
    public boolean createLogActivity(@RequestBody CreateLogActivityRequest request) {
        logActivityService.createLogActivity(request);
        return true;
    }
}
