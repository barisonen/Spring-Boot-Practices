package com.springbootpractices.wsackrabbitmq;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MainController {

    private final MessagePublisher messagePublisher;

    @PostMapping("/send-message")
    public HttpStatus sendMessage(@RequestBody String message) {
        messagePublisher.publishMessage(message);
        return HttpStatus.OK;
    }
}
