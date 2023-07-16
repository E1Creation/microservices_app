package com.indivara.loggingservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLogApiRequest  {

  private String serviceName;

  private String principalName;

  private String requestUri;

  private String requestMethod;

  private String remoteAddress;

  private String request;

  private String response;

  private Long executionTimeInMs;
}
