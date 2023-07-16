package com.indivara.loggingrestclient.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateLogApiRequest {

  private String serviceName;

  private String principalName;

  private String requestUri;

  private String requestMethod;

  private String remoteAddress;

  private String request;

  private String response;

  private Long executionTimeInMs;
}
