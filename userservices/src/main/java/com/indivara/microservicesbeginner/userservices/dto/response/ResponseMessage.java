package com.indivara.microservicesbeginner.userservices.dto.response;

import lombok.Builder;

@Builder
public class ResponseMessage {
    private Integer code;
    private String message;

    public ResponseMessage(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
