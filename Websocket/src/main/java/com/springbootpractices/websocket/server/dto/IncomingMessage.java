package com.springbootpractices.websocket.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomingMessage {
    private String name;
    private String clientInfo;
    private String content;
}
