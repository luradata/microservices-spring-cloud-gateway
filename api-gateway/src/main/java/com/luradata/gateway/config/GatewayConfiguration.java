package com.luradata.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("user-service", r -> r.path("/user/**")
                .filters(f -> f.stripPrefix(1))
                .uri("lb://user-service"))
            .route("book-service", r -> r.path("/book/**")
                .filters(f -> f.stripPrefix(1))
                .uri("lb://book-service"))
            .build();
    }
}
