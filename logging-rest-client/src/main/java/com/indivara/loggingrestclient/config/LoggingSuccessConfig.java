package com.indivara.loggingrestclient.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Data
@Configuration
@ConfigurationProperties(prefix = "publisher.success")
@Component
public class LoggingSuccessConfig {
    private String topic;
}
