package com.indivara.loggingservice.converter;

import com.indivara.loggingservice.dto.request.CreateLogApiRequest;
import com.indivara.loggingservice.entity.LogApi;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class LogApiConverter {

  public LogApi toModelLogApi(CreateLogApiRequest request) {
    final LogApi logApi = new LogApi();
    logApi.setRequest(request.getRequest());
    logApi.setExecutionTimeInMs(request.getExecutionTimeInMs());
    logApi.setResponse(request.getResponse());
    logApi.setRemoteAddress(request.getRemoteAddress());
    logApi.setRequestMethod(request.getRequestMethod());
    logApi.setRequestUri(request.getRequestUri());
    logApi.setServiceName(request.getServiceName());
    logApi.setCreatedBy(request.getPrincipalName());
    logApi.setCreatedDate(ZonedDateTime.now());
    return logApi;
  }
}
