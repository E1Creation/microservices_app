package com.indivara.apigateway;

import com.indivara.apigateway.filter.AuthenticationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        System.out.println("test");
//        return builder.routes()
//                .route("Microservice1",r->r.path("/api/v1/**")
//                        .filters(f-> f.addResponseHeader("Hello", "World"))
//                        .uri("http://localhost:8082/"))
//                .route("path_route", r -> r.path("/get")
//                        .uri("http://httpbin.org"))
//                .build();
//    }
}
