package com.springbootpractices.wsackrabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageSubscriber {

    @RabbitListener(queues = "queue-name")
    public void receiveMessage(String message) {
        System.out.println("Message received: " + message);
    }
}