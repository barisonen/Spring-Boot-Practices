package com.springbootpracticex.statemachine.service;

import com.springbootpracticex.statemachine.enums.Events;
import com.springbootpracticex.statemachine.enums.States;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Log4j2
@Service
@RequiredArgsConstructor
public class MainService {

    private final StateMachine<States, Events> stateMachine;

    public void process() {
        stateMachine
                .sendEvent(Mono.just(MessageBuilder.withPayload(Events.APPROVE).build()))
                .subscribe();
        stateMachine
                .sendEvent(Mono.just(MessageBuilder.withPayload(Events.APPROVE).build()))
                .subscribe();
    }

    public void reset() {
        stateMachine
                .sendEvent(Mono.just(MessageBuilder.withPayload(Events.RESET).build()))
                .subscribe();
    }
}
