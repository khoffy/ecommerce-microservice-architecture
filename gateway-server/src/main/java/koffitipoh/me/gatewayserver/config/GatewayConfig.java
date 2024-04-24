// package com.micrommerce.config;

// import org.springframework.cloud.gateway.route.RouteLocator;
// import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class GatewayConfig {
//     @Bean
//     public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
//         return builder.routes()
//                 .route(r -> r.path("/produits/**")
//                         .uri("lb://MICROSERVICE-PRODUITS"))

//                 .route(r -> r.path("/paiement/**")
//                         .uri("lb://MICROSERVICE-PAIEMENT"))
//                 .route(r -> r.path("/commandes/**")
//                         .uri("lb://MICROSERVICE-COMMANDES"))
//                 .build();
//     }   
// }
