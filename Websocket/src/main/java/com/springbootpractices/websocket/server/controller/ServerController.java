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

        String output =
                "(Server) Hi everyone! " +
                        incomingMessage.getName() +
                        " from " + incomingMessage.getClientInfo() +
                " said: " + incomingMessage.getContent();

        return new OutgoingMessage(output);
    }
}