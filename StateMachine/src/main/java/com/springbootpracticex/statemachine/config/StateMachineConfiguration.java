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

import java.util.Random;

@Log4j2
@RequiredArgsConstructor
@Configuration
@EnableStateMachine
public class StateMachineConfiguration extends StateMachineConfigurerAdapter<States, Events> {

    private static final String COMPANY_SECRET_MESSAGE = "STATE_MACHINE_X";
    private final StateMachineListener stateMachineListener;
    Random random = new Random();

    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config)
            throws Exception {
        config.withConfiguration().autoStartup(true).listener(stateMachineListener);
    }

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
        states.withStates()
                .initial(States.COLLEAGUE_REVIEW)
                .state(States.TEAM_LEAD_REVIEW)
                .end(States.APPROVED)
                .end(States.REJECTED);
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
            throws Exception {
        transitions
                .withExternal()
                .source(States.COLLEAGUE_REVIEW)
                .target(States.TEAM_LEAD_REVIEW)
                .event(Events.APPROVE)
                .action(executeAction())
                .and()
                .withExternal()
                .source(States.TEAM_LEAD_REVIEW)
                .target(States.APPROVED)
                .event(Events.APPROVE)
                .action(executeAction())
                .guard(guard())
                .and()
                .withExternal()
                .source(States.COLLEAGUE_REVIEW)
                .target(States.REJECTED)
                .event(Events.REJECT)
                .and()
                .withExternal()
                .source(States.TEAM_LEAD_REVIEW)
                .target(States.REJECTED)
                .event(Events.REJECT)
                .and()
                .withExternal()
                .source(States.COLLEAGUE_REVIEW)
                .target(States.COLLEAGUE_REVIEW)
                .event(Events.RESET)
                .and()
                .withExternal()
                .source(States.TEAM_LEAD_REVIEW)
                .target(States.COLLEAGUE_REVIEW)
                .event(Events.RESET)
                .and()
                .withExternal()
                .source(States.APPROVED)
                .target(States.COLLEAGUE_REVIEW)
                .event(Events.RESET)
                .and()
                .withExternal()
                .source(States.APPROVED)
                .target(States.COLLEAGUE_REVIEW)
                .event(Events.RESET);
    }

    @Bean
    public Action<States, Events> executeAction() {
        return ctx -> {
            log.info("");
            log.info("Execute " + ctx.getEvent().name());

            String companySecretSignature =
                    random.nextBoolean() ? COMPANY_SECRET_MESSAGE : "BAD SIGNATURE";

            ctx.getExtendedState()
                    .getVariables()
                    .put("COMPANY_SECRET_SIGNATURE", companySecretSignature);
        };
    }

    @Bean
    public Guard<States, Events> guard() {
        return ctx -> {
            String givenSecretSignature =
                    (String)
                            ctx.getExtendedState()
                                    .getVariables()
                                    .getOrDefault("COMPANY_SECRET_SIGNATURE", null);

            log.info("Guard: Checking if company secret signature is correct.");
            log.info("Given signature: " + givenSecretSignature);
            log.info("Company Signature: " + COMPANY_SECRET_MESSAGE);

            boolean result = COMPANY_SECRET_MESSAGE.equals(givenSecretSignature);

            if (result) {
                log.info("Signature validated! Guard gave the permission");
                return true;
            } else {
                log.info("Signature not valid! Guard is stopping the process.");
                return false;
            }
        };
    }
}
