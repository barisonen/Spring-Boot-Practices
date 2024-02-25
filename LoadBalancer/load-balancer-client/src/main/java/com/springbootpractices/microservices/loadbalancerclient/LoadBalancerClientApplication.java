package com.springbootpractices.microservices.loadbalancerclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class LoadBalancerClientApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =
                new SpringApplicationBuilder(LoadBalancerClientApplication.class)
                        .web(WebApplicationType.NONE)
                        .run(args);

        WebClient loadBalancedClient = ctx.getBean(WebClient.Builder.class).build();

        for (int i = 0; i < 10; i++) {
            ResponseEntity<String> response = loadBalancedClient.get().uri("http://load-balancer-client/hello")
                    .retrieve().toEntity(String.class)
                    .block();

            if (response != null) {
                System.out.println(response.getBody());
            }
        }
    }

}
