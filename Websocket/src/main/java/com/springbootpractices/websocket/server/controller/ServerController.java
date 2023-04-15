package com.springbootpractices.websocket.server.controller;

import com.springbootpractices.websocket.server.dto.IncomingMessage;
import com.springbootpractices.websocket.server.dto.OutgoingMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ServerController {

    @MessageMapping("/process-message")
    @SendTo("/topic/messages")
    public OutgoingMessage processMessage(IncomingMessage incomingMessage)
        throws Exception {
        Thread.sleep(1000);
        System.out.println("(Server) Received : " + incomingMessage.getName());
        String output = "Hello " + incomingMessage.getName();
        System.out.println("(Server) Returning : " + output);
        System.out.println("------");
        return new OutgoingMessage(output);
    }
}