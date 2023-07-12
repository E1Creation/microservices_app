package com.indivara.paymentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.indivara")
public class PaymentserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(PaymentserviceApplication.class, args);
	}
}
