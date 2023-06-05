package com.springbootpractices.wsackrabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publishMessage(String message) {
        rabbitTemplate.convertAndSend("", "queue-name", message);
        System.out.println("Message sent: " + message);
    }
}