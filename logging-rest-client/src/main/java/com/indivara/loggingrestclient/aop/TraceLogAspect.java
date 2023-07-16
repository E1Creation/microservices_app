package com.indivara.loggingrestclient.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.indivara.loggingrestclient.config.LoggingSuccessConfig;
import com.indivara.loggingrestclient.dto.request.CreateLogApiRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Aspect
@Configuration
@Slf4j
public class TraceLogAspect {
    private final LoggingSuccessConfig loggingSuccessConfig;
    private final KafkaTemplate<String,String> kafkaTemplate;
    private ObjectMapper objectMapper = new ObjectMapper();
    @Value("${spring.application.name}")
    private String serviceName;
    private final String START_EXECUTION_TIME = "START_EXECUTION_TIME";

    @Before(value = "@annotation(com.indivara.loggingrestclient.aop.TraceLog)")
    public void before(JoinPoint joinPoint) {
        log.info("Received request for method: {}, arguments: {}",
                joinPoint.getSignature().getName(),
                joinPoint.getArgs());
        MDC.put(START_EXECUTION_TIME, String.valueOf(System.currentTimeMillis()));
    }
    @AfterReturning(
            value = "@annotation(com.indivara.loggingrestclient.aop.TraceLog)",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {
        final long startExecutionTime = Long.parseLong(MDC.get(START_EXECUTION_TIME));
        final long endExecutionTime = System.currentTimeMillis();
        final long totalTime = endExecutionTime - startExecutionTime;
        log.info("Finished request for method: {} with execution time {} ms, result: {}",
                joinPoint.getSignature().getName(),
                totalTime,
                result
        );
        final HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes())
                .getRequest();
        try {
            final Object[] aspectArguments = joinPoint.getArgs();
            final String request = toString(aspectArguments);
            final String response = toString(result);
            final CreateLogApiRequest logApiRequest = CreateLogApiRequest
                    .builder()
                    .serviceName(serviceName)
                    .requestUri(httpServletRequest.getRequestURI())
                    .requestMethod(httpServletRequest.getMethod())
                    .remoteAddress(httpServletRequest.getRemoteAddr())
                    .request(request)
                    .response(response)
                    .executionTimeInMs(totalTime)
                    .build();
            System.out.println("kafka");
            System.out.println("TOPIC : " + loggingSuccessConfig.getTopic());
            kafkaTemplate.send("com.indivara.logging.saving.data.success", toString(logApiRequest));
        } catch (Exception e) {
            log.error("Failed to catch Aspect AfterReturning from controller", e);
        }
    }

    private String toString(Object[] args) {
        try {
            return objectMapper.writeValueAsString(args);
        } catch (JsonProcessingException e) {
            log.error("error parsing to string", e);
        }

        return "";
    }

    private String toString(Object result) {
        try {
            return objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            log.error("error parsing to string", e);
        }

        return "";
    }
}
