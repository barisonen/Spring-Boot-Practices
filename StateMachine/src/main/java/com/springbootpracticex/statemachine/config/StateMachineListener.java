package com.springbootpracticex.statemachine.config;

import com.springbootpracticex.statemachine.enums.Events;
import com.springbootpracticex.statemachine.enums.States;

import lombok.extern.log4j.Log4j2;

import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StateMachineListener extends StateMachineListenerAdapter<States, Events> {

    @Override
    public void stateChanged(State from, State to) {
        log.info(
                () -> String.format("Transitioned from %s to %s%n",
                from == null ? "none" : from.getId(),
                to.getId()));
    }
}
