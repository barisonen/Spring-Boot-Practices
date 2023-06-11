package com.springbootpracticex.statemachine.config;

import com.springbootpracticex.statemachine.enums.Events;
import com.springbootpracticex.statemachine.enums.States;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.guard.Guard;

@Log4j2
@RequiredArgsConstructor
@Configuration
@EnableStateMachine
public class StateMachineConfiguration extends StateMachineConfigurerAdapter<States, Events> {

    private final StateMachineListener stateMachineListener;

    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config)
            throws Exception {
        config.withConfiguration().autoStartup(true).listener(stateMachineListener);
    }

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
        states.withStates()
                .initial(States.PEER_REVIEW)
                .state(States.PRINCIPAL_REVIEW)
                .end(States.APPROVED)
                .end(States.REJECTED);
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
            throws Exception {
        transitions
                .withExternal()
                .source(States.PEER_REVIEW)
                .target(States.PRINCIPAL_REVIEW)
                .event(Events.APPROVE)
                .and()
                .withExternal()
                .source(States.PRINCIPAL_REVIEW)
                .target(States.APPROVED)
                .event(Events.APPROVE)
                .and()
                .withExternal()
                .source(States.PEER_REVIEW)
                .target(States.REJECTED)
                .event(Events.REJECT)
                .and()
                .withExternal()
                .source(States.PRINCIPAL_REVIEW)
                .target(States.REJECTED)
                .event(Events.REJECT);
    }

    @Bean
    public Action<String, String> initAction() {
        return ctx -> log.info(ctx.getTarget().getId());
    }

    @Bean
    public Action<String, String> executeAction() {
        return ctx -> {
            log.info("Execute " + ctx.getTarget().getId());

            int approvals =
                    (int) ctx.getExtendedState().getVariables().getOrDefault("approvalCount", 0);

            approvals++;

            ctx.getExtendedState().getVariables().put("approvalCount", approvals);
        };
    }

    @Bean
    public Action<String, String> errorAction() {
        return ctx -> log.info("Error " + ctx.getSource().getId() + ctx.getException());
    }

    @Bean
    public Action<String, String> entryAction() {
        return ctx -> log.info("Entry " + ctx.getTarget().getId());
    }

    @Bean
    public Action<String, String> exitAction() {
        return ctx ->
                log.info("Exit " + ctx.getSource().getId() + " -> " + ctx.getTarget().getId());
    }

    @Bean
    public Guard<String, String> guard() {
        return ctx -> {
            int approvalCount =
                    (int) ctx.getExtendedState().getVariables().getOrDefault("approvalCount", 0);
            return approvalCount > 0;
        };
    }
}
