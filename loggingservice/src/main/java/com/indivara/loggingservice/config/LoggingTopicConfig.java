package com.indivara.loggingservice.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "service.consumer")
public class LoggingTopicConfig {
    private String topic;
}
