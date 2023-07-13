package com.indivara.microservicesbeginner.userservices.error;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class InvalidAuthHeaderException extends RuntimeException{

    private Integer code;
    private String message;

    public InvalidAuthHeaderException(){
        this.code = 402;
        this.message = "Invalid Authorization Header";
    }
}
