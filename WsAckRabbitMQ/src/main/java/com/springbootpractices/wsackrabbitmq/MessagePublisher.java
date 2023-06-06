package com.springbootpractices.wsackrabbitmq;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessagePublisher {

    private final RabbitTemplate rabbitTemplate;

    public void publishMessage(String message) {
        rabbitTemplate.convertAndSend("", "queue-name", message);
        System.out.println("Message sent: " + message);
    }
}