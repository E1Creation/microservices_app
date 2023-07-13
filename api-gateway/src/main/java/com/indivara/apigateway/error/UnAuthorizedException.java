package com.indivara.apigateway.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;

@Data
public class UnAuthorizedException extends RuntimeException{

    private Integer code;
    private String message;

    public UnAuthorizedException(){
        this.code = 403;
        this.message = "Invalid Token";
    }
}
