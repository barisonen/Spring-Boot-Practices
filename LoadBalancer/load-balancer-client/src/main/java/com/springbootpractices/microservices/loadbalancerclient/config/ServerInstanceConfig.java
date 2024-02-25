package com.springbootpractices.microservices.loadbalancerclient.config;

import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerInstanceConfig {

    @Bean
    ServiceInstanceListSupplier serviceInstanceListSupplier() {
        return new InstanceSupplier("load-balancer-client");
    }
}
