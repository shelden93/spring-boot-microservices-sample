package org.shelden.ss.base.rabbit.service.impl;

import org.shelden.ss.base.rabbit.message.Message;
import org.shelden.ss.base.rabbit.service.RabbitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public abstract class AbstractRabbitService<T extends Message> implements RabbitService<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractRabbitService.class);

    private final RabbitTemplate template;

    public AbstractRabbitService(RabbitTemplate template) {
        this.template = template;
    }

    @Override
    public void send(T message, String queue) {

        if (!isAllowedQueue(queue)) {
            throw new RuntimeException();
        }

        template.convertAndSend(queue, message);
    }

    protected abstract boolean isAllowedQueue(String name);
}
