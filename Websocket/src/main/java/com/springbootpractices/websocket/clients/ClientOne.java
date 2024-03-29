package com.springbootpractices.websocket.clients;

import com.springbootpractices.websocket.server.dto.IncomingMessage;
import com.springbootpractices.websocket.server.dto.OutgoingMessage;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ClientOne {
    public static void main(String[] args)
        throws ExecutionException, InterruptedException {
        WebSocketClient client = new StandardWebSocketClient();

        WebSocketStompClient stompClient = new WebSocketStompClient(client);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());

        ClientOneSessionHandler clientOneSessionHandler =
                new ClientOneSessionHandler();

        CompletableFuture<StompSession> sessionAsync =
                stompClient.connectAsync("ws://localhost:8080/websocket-server", clientOneSessionHandler);

        StompSession session = sessionAsync.get();
        session.subscribe("/topic/messages", clientOneSessionHandler);

        while (true) {
            session.send(
                    "/app/process-message",
                    new IncomingMessage("Baris", "client 1", "Hiiii")
            );

            Thread.sleep(2000);
        }
    }
}

class ClientOneSessionHandler extends StompSessionHandlerAdapter {
    @Override
    public Type getPayloadType(StompHeaders headers) {
        return OutgoingMessage.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        System.out.println("(Client 1) " + new Date() + " Received : " + ((OutgoingMessage) payload).getContent());
        System.out.println("------");
    }
}