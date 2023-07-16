package com.indivara.loggingservice.converter;

import com.indivara.loggingservice.dto.request.CreateLogActivityRequest;
import com.indivara.loggingservice.entity.LogActivity;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class LogActivityConverter {

  public LogActivity toModelLogActivity(CreateLogActivityRequest request) {
    final LogActivity logActivity = new LogActivity();
    logActivity.setEvent(request.getEvent());
    logActivity.setServiceName(request.getServiceName());
    logActivity.setBefore(request.getBefore());
    logActivity.setAfter(request.getAfter());
    logActivity.setCreatedBy(request.getPrincipalName());
    logActivity.setCreatedDate(ZonedDateTime.now());
    return logActivity;
  }


}
