package com.springbootpractices.wsackrabbitmq;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WebSocketSender {

    private final SimpMessageSendingOperations messagingTemplate;

    public void sendMessage(String uri, Object message) { messagingTemplate.convertAndSend(uri, message); }
}
