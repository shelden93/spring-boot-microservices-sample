package org.shelden.ss.logs.rabbit.listener;

import org.shelden.ss.base.rabbit.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static org.shelden.ss.base.configuration.RabbitConfiguration.QUEUE_AUTH_LOGS;

@Component
public class AuthenticationQueueListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationQueueListener.class);

    @RabbitListener(queues = QUEUE_AUTH_LOGS)
    public void process(Message message) {
        LOGGER.info("Received the Authorization Message: " + message);
    }
}
