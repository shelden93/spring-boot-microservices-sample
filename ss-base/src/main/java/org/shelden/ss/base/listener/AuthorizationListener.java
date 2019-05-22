package org.shelden.ss.base.listener;

import org.shelden.ss.base.rabbit.message.Message;
import org.shelden.ss.base.rabbit.service.RabbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import static org.shelden.ss.base.configuration.RabbitConfiguration.QUEUE_AUTH_LOGS;
import static org.shelden.ss.base.rabbit.message.Message.withUsername;

@Component
public class AuthorizationListener {

    @Autowired
    private RabbitService<Message> rabbitService;

    @EventListener
    public void authenticationSuccess(AuthenticationSuccessEvent event) {
        final Authentication authentication = event.getAuthentication();
        rabbitService.send(withUsername(authentication.getName()), QUEUE_AUTH_LOGS);
    }
}
