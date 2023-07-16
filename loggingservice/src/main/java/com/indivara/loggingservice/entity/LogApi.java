package com.indivara.loggingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "log_api")
public class LogApi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;

    private String requestUri;
    private String requestMethod;
    private String remoteAddress;

    private String request;

    private String response;
    private Long executionTimeInMs;
    private String createdBy;
    private ZonedDateTime createdDate;
}
