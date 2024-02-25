package com.springbootpractices.microservices.loadbalancerclient.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@LoadBalancerClient(name = "load-balancer-client", configuration = ServerInstanceConfig.class)
public class WebClientConfig {

    @Bean
    @LoadBalanced
    WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
}
