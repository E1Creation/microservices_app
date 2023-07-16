package com.indivara.loggingservice.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CreateLogActivityRequest {

  private String principalName;

  private String serviceName;

  private String event;

  private String entity;

  private String before;

  private String after;
}
