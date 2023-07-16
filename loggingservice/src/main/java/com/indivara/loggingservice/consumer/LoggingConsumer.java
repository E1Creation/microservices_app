package com.indivara.loggingservice.consumer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.indivara.loggingservice.dto.request.CreateLogApiRequest;
import com.indivara.loggingservice.service.LogActivityService;
import com.indivara.loggingservice.service.LogApiService;
import com.indivara.loggingservice.util.CommonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class LoggingConsumer {
    private final LogApiService logApiService;

    @KafkaListener(topics = "com.indivara.logging.saving.data.success")
    public void consumeLoggingApiAllService(ConsumerRecord<String, String> consumerRecord){
        log.info("Consume Logging API start ...");
        log.info("consumer value : {}", consumerRecord.value());
        CreateLogApiRequest request = CommonUtils.convertKafkaMessage(
                consumerRecord.value(),
                new TypeReference<>() {
                }
        );
        logApiService.createLogApi(request);
    }
}
