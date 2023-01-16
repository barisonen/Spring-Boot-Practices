package com.example.websocket.controller;

import com.example.websocket.apimodel.InputMessage;
import com.example.websocket.apimodel.OutputMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ChatController {

    private final SimpMessagingTemplate simpMessagingTemplate;
    private boolean adminStarted = false;

    public ChatController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(final InputMessage message) throws Exception {

        if(!adminStarted) {
            adminStarted = true;
            startAdmin();
        }
        final String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }

    @Scheduled(fixedRate = 3000)
    public void startAdmin() {

        final String time = new SimpleDateFormat("HH:mm").format(new Date());
        simpMessagingTemplate.convertAndSend("/topic/messages",
                new OutputMessage("Admin", "I talk too much", time));
    }

}
