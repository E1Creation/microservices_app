package com.indivara.productservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.indivara")
public class ProductservicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductservicesApplication.class, args);
    }

}
