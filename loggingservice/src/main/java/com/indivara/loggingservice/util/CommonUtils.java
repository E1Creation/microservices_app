package com.indivara.loggingservice.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Optional;

@Slf4j
public class CommonUtils {

    public static <T> T convertKafkaMessage(String json, TypeReference<T> typeReference) {
        T data = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            data = mapper.readValue(json, typeReference);
        } catch (NullPointerException | IOException e) {
            log.error("Error converting kafka message to object. json {}", json, e);
        }

        return data;
    }
}
